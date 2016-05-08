package com.fanhl.logview;

import com.fanhl.logview.model.LogFilterCondition;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.model.LogLevel;
import com.fanhl.logview.util.ListUtil;
import com.fanhl.logview.util.Stabilizer;
import com.fanhl.logview.util.StringUtil;

import java.util.LinkedList;

/**
 * The core of log.Just logic.No relationship of ui.
 * <p/>
 * Created by fanhl on 16/5/3.
 */
public class LogCore {
    private static final int STABILIZER_TIME = 100;
    private static final int LIMIT_LENGTH    = 100;

    private static final Stabilizer stabilizer;

    private static final LinkedList<LogItem> fullLogs;
    private static final LinkedList<LogItem> filteredLogs;
    private static final LinkedList<LogItem> bufferFullLogs;
    private static final LinkedList<LogItem> bufferFilterdLogs;

    private static final ListUtil.Filter<LogItem> logItemFilter;

    private static LogFilterCondition logFilterCondition;

    private static Callback callback;

    static {
        stabilizer = new Stabilizer(STABILIZER_TIME);

        fullLogs = new LinkedList<LogItem>();// Collections.synchronizedList(new LinkedList<LogItem>());
        filteredLogs = new LinkedList<LogItem>();// Collections.synchronizedList(new LinkedList<LogItem>());
        bufferFullLogs = new LinkedList<LogItem>();//Collections.synchronizedList(new LinkedList<LogItem>());
        bufferFilterdLogs = new LinkedList<LogItem>();//Collections.synchronizedList(new LinkedList<LogItem>());

        logItemFilter = new ListUtil.Filter<LogItem>() {
            @Override public boolean filter(LogItem logItem) {
                return logFilterCondition == null || logItem.getLogLevel().getIndex() >= logFilterCondition.getLogLevel().getIndex();
            }
        };

        logFilterCondition = new LogFilterCondition(LogLevel.D, "");
    }

    /**
     * fixme synchronized logic
     *
     * @param logItem
     */
    public static void addLog(LogItem logItem) {
        synchronized (LogCore.class) {
            //add buffer log
            bufferFullLogs.add(logItem);
            while (bufferFullLogs.size() > LIMIT_LENGTH) bufferFullLogs.poll();


            //refresh log ui per 100 milliseconds
            if (!stabilizer.check()) return;
            stabilizer.actived();


            //add log from butter log
            fullLogs.addAll(bufferFullLogs);

            ListUtil.filter(bufferFullLogs, bufferFilterdLogs, logItemFilter);
            filteredLogs.addAll(bufferFilterdLogs);

            bufferFullLogs.clear();
            bufferFilterdLogs.clear();

            while (fullLogs.size() > LIMIT_LENGTH) fullLogs.poll();
            while (filteredLogs.size() > LIMIT_LENGTH) filteredLogs.poll();

            if (callback != null) callback.onFilteredLogsChanged();
        }
    }

    public static void setCallback(Callback callback) {
        LogCore.callback = callback;
    }

    public static void setLogFilterCondition(LogFilterCondition logFilterCondition) {
        //if same
        if (LogCore.logFilterCondition != null && LogCore.logFilterCondition.getLogLevel() == logFilterCondition.getLogLevel() && StringUtil.equals(LogCore.logFilterCondition.getQuery(), logFilterCondition.getQuery())) {
            return;
        }
        LogCore.logFilterCondition = logFilterCondition;

        synchronized (LogCore.class) {
            filteredLogs.clear();
            ListUtil.filter(fullLogs, filteredLogs, logItemFilter);
        }

        if (callback != null) callback.onLogFilterConditionChanged();
    }

    public interface Callback {
        void onFilteredLogsChanged();

        void onLogFilterConditionChanged();
    }
}
