package com.fanhl.logview.model;

/**
 * Log bean.
 * <p/>
 * Created by fanhl on 16/5/1.
 */
public class LogItem {
    private final Type   type;
    private final String tag;
    private final long   date;
    private final String msg;

    public LogItem(Type type, String tag, long date, String msg) {
        this.type = type;
        this.tag = tag;
        this.date = date;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getLog() {
        return date + "|" + msg;// FIXME: 16/5/1
    }

    public enum Type {V, D, I, W, E, A}
}
