package com.fanhl.logview;

import com.fanhl.logview.model.LogFilterCondition;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.util.ListUtil;
import com.fanhl.logview.util.Stabilizer;
import com.fanhl.logview.util.StringUtil;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * The core of log.Just logic.No relationship of ui.
 * <p/>
 * Created by fanhl on 16/5/3.
 */
public class LogCore extends Observable {
    private static final int STABILIZER_TIME = 100;
    private static final int LIMIT_LENGTH    = 100;

    private static final Stabilizer stabilizer;

    private static final List<LogItem> fullLogs;
    private static final List<LogItem> filteredLogs;
    private static final List<LogItem> bufferFullLogs;
    private static final List<LogItem> bufferFilterdLogs;

    private static final ListUtil.Filter<LogItem> logItemFilter;

    private static LogFilterCondition logFilterCondition;

    static {
        stabilizer = new Stabilizer(STABILIZER_TIME);

        fullLogs = Collections.synchronizedList(new LinkedList<LogItem>());
        filteredLogs = Collections.synchronizedList(new LinkedList<LogItem>());
        bufferFullLogs = Collections.synchronizedList(new LinkedList<LogItem>());
        bufferFilterdLogs = Collections.synchronizedList(new LinkedList<LogItem>());

        logItemFilter = new ListUtil.Filter<LogItem>() {
            @Override public boolean filter(LogItem logItem) {
                return logItem.getLogLevel().getIndex() >= logFilterCondition.getLogLevel().getIndex();
            }
        };
    }

    public static void addLog(LogItem logItem) {
        //add buffer log
        bufferFullLogs.add(logItem);
        synchronized (bufferFullLogs) {
            int overflowCount = bufferFullLogs.size() - LIMIT_LENGTH;
            if (overflowCount > 0) bufferFullLogs.removeAll(bufferFullLogs.subList(0, overflowCount));
        }

        //refresh log ui per 100 milliseconds
        if (!stabilizer.check()) return;
        stabilizer.actived();

        //add log from butter log
        synchronized (bufferFullLogs) {
            fullLogs.addAll(bufferFullLogs);

            ListUtil.filter(bufferFullLogs, bufferFilterdLogs, logItemFilter);
            filteredLogs.addAll(bufferFilterdLogs);

            bufferFullLogs.clear();
            bufferFilterdLogs.clear();
        }

        synchronized (fullLogs) {
            int overflowCount = fullLogs.size() - LIMIT_LENGTH;
            if (overflowCount > 0) fullLogs.removeAll(fullLogs.subList(0, overflowCount));
        }

        synchronized (filteredLogs) {
            int overflowCount = filteredLogs.size() - LIMIT_LENGTH;
            if (overflowCount > 0) filteredLogs.removeAll(filteredLogs.subList(0, overflowCount));
        }
    }

    public static void setLogFilterCondition(LogFilterCondition logFilterCondition) {
        //if same
        if (LogCore.logFilterCondition.getLogLevel() == logFilterCondition.getLogLevel() &&
                StringUtil.equals(LogCore.logFilterCondition.getQuery(), logFilterCondition.getQuery())) {
            return;
        }
        LogCore.logFilterCondition = logFilterCondition;
        onLogFilterConditionChanged();
    }

    public static void onLogFilterConditionChanged() {
        synchronized (fullLogs) {
            filteredLogs.clear();
            ListUtil.filter(fullLogs, filteredLogs, logItemFilter);
        }
    }
}
