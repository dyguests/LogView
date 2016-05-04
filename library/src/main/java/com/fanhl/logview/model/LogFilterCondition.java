package com.fanhl.logview.model;

/**
 * Created by fanhl on 16/5/4.
 */
public class LogFilterCondition {
    private LogLevel logLevel;
    private String   query;

    public LogFilterCondition() {
        this(LogLevel.V, null);
    }

    public LogFilterCondition(LogLevel logLevel, String query) {
        this.logLevel = logLevel;
        this.query = query;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
