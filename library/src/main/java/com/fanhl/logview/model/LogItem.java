package com.fanhl.logview.model;

/**
 * Created by fanhl on 16/5/4.
 */
public class LogItem {
    private LogLevel logLevel;
    private long     time;
    private String   tag;
    private String   message;

    public LogItem() {
        this(System.currentTimeMillis(), LogLevel.V, null, null);
    }

    public LogItem(long time, LogLevel logLevel, String tag, String message) {
        this.logLevel = logLevel;
        this.time = time;
        this.tag = tag;
        this.message = message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
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
