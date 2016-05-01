package com.fanhl.logviewsample.util;

import com.fanhl.logview.LogViewApi;

/**
 * A Custom Log with LogViewApi.
 * <p/>
 * Created by fanhl on 16/4/29.
 */
public class Log {
    public static void v(String tag, String msg) {
        android.util.Log.v(tag, msg);
        LogViewApi.v(tag, msg);
    }

    public static void v(String tag, String msg, Throwable tr) {
        android.util.Log.v(tag, msg, tr);
//        LogViewApi.v(tag, msg, tr);// FIXME: 16/5/1 fix after.
    }

    public static void d(String tag, String msg) {
        android.util.Log.d(tag, msg);
        LogViewApi.d(tag, msg);
    }

    // FIXME: 16/5/1 something log type didn't implement.

    public static void i(String tag, String msg) {
        android.util.Log.i(tag, msg);
        LogViewApi.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        android.util.Log.i(tag, msg);
        LogViewApi.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        android.util.Log.i(tag, msg);
        LogViewApi.e(tag, msg);
    }

    public static void a(String tag, String msg) {
        android.util.Log.i(tag, msg);
        LogViewApi.a(tag, msg);
    }

}
