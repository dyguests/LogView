package com.fanhl.logview;

import com.fanhl.logview.model.FilterCondition;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.util.Stabilizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The core of log.Just logic.No relationship of ui.
 * Created by fanhl on 16/5/3.
 */
public class LogCore {
    private static final int QUEUE_LENGTH = 100;

    private static final Stabilizer stabilizer;

    private static List<LogItem> logs;
    private static List<LogItem> filteredLogs;

    private static List<LogItem> bufferLogs;

    private static final FilterCondition filterCondition;

    static {
        //refresh log ui per 100 milliseconds;
        stabilizer = new Stabilizer(100);

        logs = Collections.synchronizedList(new ArrayList<LogItem>());
        filteredLogs = Collections.synchronizedList(new ArrayList<LogItem>());
        bufferLogs = Collections.synchronizedList(new ArrayList<LogItem>());

        filterCondition = new FilterCondition();
    }

    public static void addLog(LogItem logItem) {
        bufferLogs.add(logItem);
        int bufferOverflowCount = bufferLogs.size() - QUEUE_LENGTH;
        if (bufferOverflowCount > 0) bufferLogs.removeAll(bufferLogs.subList(0, bufferOverflowCount));

        if (stabilizer.check()) {
            stabilizer.actived();

            int positionStart = logs.size();
            int addItemCount  = bufferLogs.size();
            logs.addAll(bufferLogs);
            bufferLogs.clear();
            int overflowCount = logs.size() - QUEUE_LENGTH;
            if (overflowCount > 0) {
                logs.removeAll(logs.subList(0, overflowCount));
                positionStart -= overflowCount;
//                notifyItemRangeRemoved(0, overflowCount);// FIXME: 16/5/3
            }
//            notifyItemRangeInserted(positionStart, addItemCount);// FIXME: 16/5/3
        }
    }

    public static void onFilterConditionChanged(FilterCondition filterCondition) {

    }
}
