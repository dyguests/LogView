package com.fanhl.logview;

import com.fanhl.logview.model.LogItem;

import java.util.LinkedList;

/**
 * The core of log.Just logic.No relationship of ui.
 * Created by fanhl on 16/5/3.
 */
public class LogCore {
    private static LinkedList<LogItem> queue;

    static {
        queue = new LinkedList<>();
    }

}
