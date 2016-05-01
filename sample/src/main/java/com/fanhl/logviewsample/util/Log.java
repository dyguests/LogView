package com.fanhl.logviewsample.util;

import com.fanhl.logview.LogViewApi;

/**
 * Created by fanhl on 16/4/29.
 */
public class Log {
    public static void d(String tag, String msg) {
        android.util.Log.d(tag, msg);
        LogViewApi.d(tag, msg);
    }
}
