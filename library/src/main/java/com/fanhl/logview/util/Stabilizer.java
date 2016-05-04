package com.fanhl.logview.util;

/**
 * 防抖器
 * Created by fanhl on 2016/4/20.
 */
public class Stabilizer {
    /**
     * 默认防抖时间
     */
    public static final int STABILIZER_TIME_DEFAULT = 5 * 1000;

    /**
     * 防抖时间
     */
    long stabilizerTime = STABILIZER_TIME_DEFAULT;

    long lastTime = 0;

    /**
     * 是否可以使用（已超过防抖时间）
     */
    public boolean check() {
        return System.currentTimeMillis() > lastTime + stabilizerTime;
    }

    /**
     * 动了一下
     */
    public void actived() {
        lastTime = System.currentTimeMillis();
    }

    /**
     * 重置
     */
    public void reset() {
        lastTime = 0;
    }

    public long getStabilizerTime() {
        return stabilizerTime;
    }

    public void setStabilizerTime(long stabilizerTime) {
        this.stabilizerTime = stabilizerTime;
    }
}
