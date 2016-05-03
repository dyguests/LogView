package com.fanhl.logview.model;

/**
 * Created by fanhl on 16/5/3.
 */
public class FilterCondition {
    private LogLevel level;
    private String   query;

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
