package com.fanhl.logview;

import com.fanhl.logview.model.LogItem;

import java.util.LinkedList;

/**
 * Created by fanhl on 16/5/1.
 */
public class LogViewCore {
    private final static LinkedList<LogItem> sQueue;

    static {
        sQueue = new LinkedList<>();
    }

    static void addDebugLog(String tag, String msg) {
        LogItem object = new LogItem(LogItem.Type.D, tag, System.currentTimeMillis(), msg);
        sQueue.add(object);
        // FIXME: 16/5/1 notify change
    }

    public static LinkedList<LogItem> getQueue() {
        return sQueue;
    }
}
