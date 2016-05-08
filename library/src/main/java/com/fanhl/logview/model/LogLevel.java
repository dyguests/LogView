package com.fanhl.logview.model;

/**
 * Created by fanhl on 16/5/4.
 */
public enum LogLevel {
    V(0), D(1), I(2), W(3), E(4), A(5);

    private final int index;

    LogLevel(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
