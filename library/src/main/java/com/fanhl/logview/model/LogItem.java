package com.fanhl.logview.model;

import com.fanhl.logview.util.DateUtil;

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

    public Type getType() {
        return type;
    }

    public String getTag() {
        return tag;
    }

    public long getDate() {
        return date;
    }

    public String getMsg() {
        return msg;
    }

    public String getLog() {
        return DateUtil.long2mmssSSS(date) + "|" + msg;// FIXME: 16/5/1
    }

    public enum Type {V, D, I, W, E, A}
}
