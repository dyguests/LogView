package com.fanhl.logview.model;

import com.fanhl.logview.util.DateUtil;

/**
 * Created by fanhl on 16/5/4.
 */
public class LogItem {
    private LogLevel level;
    private long     time;
    private String   tag;
    private String   message;

    public LogItem() {
        this(System.currentTimeMillis(), LogLevel.V, null, null);
    }

    public LogItem(long time, LogLevel logLevel, String tag, String message) {
        this.level = logLevel;
        this.time = time;
        this.tag = tag;
        this.message = message;
    }

    public String getLog() {
        return DateUtil.long2mmssSSS(time) + "|" + message;// FIXME: 16/5/1
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
