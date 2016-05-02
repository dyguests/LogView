package com.fanhl.logview;

import android.app.Activity;

import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.model.LogLevel;

/**
 * Created by fanhl on 16/4/29.
 */
public class LogViewApi {

    private static boolean enable = true;

    public static void bind(Activity activity) {
        if (!enable) return;
        LogViewCore.bind(activity);
    }

    public static void setEnable(boolean enable) {
        LogViewApi.enable = enable;
    }

    public static void v(String tag, String msg) {
        if (!enable) return;
        LogViewCore.addLog(new LogItem(LogLevel.V, tag, System.currentTimeMillis(), msg));
    }

    public static void d(String tag, String msg) {
        if (!enable) return;
        LogViewCore.addLog(new LogItem(LogLevel.D, tag, System.currentTimeMillis(), msg));
    }

    public static void i(String tag, String msg) {
        if (!enable) return;
        LogViewCore.addLog(new LogItem(LogLevel.I, tag, System.currentTimeMillis(), msg));
    }

    public static void w(String tag, String msg) {
        if (!enable) return;
        LogViewCore.addLog(new LogItem(LogLevel.W, tag, System.currentTimeMillis(), msg));
    }

    public static void e(String tag, String msg) {
        if (!enable) return;
        LogViewCore.addLog(new LogItem(LogLevel.E, tag, System.currentTimeMillis(), msg));
    }

    public static void a(String tag, String msg) {
        if (!enable) return;
        LogViewCore.addLog(new LogItem(LogLevel.A, tag, System.currentTimeMillis(), msg));
    }

}
