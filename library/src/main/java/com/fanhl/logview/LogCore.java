package com.fanhl.logview;

import com.fanhl.logview.model.LogFilter;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.util.Stabilizer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The core of log.Just logic.No relationship of ui.
 * <p/>
 * Created by fanhl on 16/5/3.
 */
public class LogCore {
    private static final int LIMIT_LENGTH = 100;

    private static final Stabilizer stabilizer;

    private static final List<LogItem> fullLogs;
    private static final List<LogItem> filterdLogs;
    private static final List<LogItem> bufferLogs;

    private static LogFilter logFilter;

    static {
        stabilizer = new Stabilizer();

        fullLogs = Collections.synchronizedList(new LinkedList<LogItem>());
        filterdLogs = Collections.synchronizedList(new LinkedList<LogItem>());
        bufferLogs = Collections.synchronizedList(new LinkedList<LogItem>());

        logFilter = new LogFilter();
    }

    public void addLog(LogItem logItem) {
        addBufferLog(logItem);

        if (!stabilizer.check()) return;
        stabilizer.actived();


    }

    private void addBufferLog(LogItem logItem) {
        bufferLogs.add(logItem);
        int overflowCount = bufferLogs.size() - LIMIT_LENGTH;
        if (overflowCount > 0) bufferLogs.removeAll(bufferLogs.subList(0, overflowCount));
    }
}
