package com.fanhl.logview.model;

import com.fanhl.logview.util.DateUtil;

/**
 * Log bean.
 * <p/>
 * Created by fanhl on 16/5/1.
 */
public class LogItem {
    private final LogLevel level;
    private final String   tag;
    private final long     date;
    private final String   msg;

    public LogItem(LogLevel level, String tag, long date, String msg) {
        this.level = level;
        this.tag = tag;
        this.date = date;
        this.msg = msg;
    }

    public LogLevel getLevel() {
        return level;
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

}
