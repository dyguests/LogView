package com.fanhl.logview;

import android.app.Activity;

import com.fanhl.logview.model.LogItem;

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

    public static void d(String tag, String msg) {
        if (!enable) return;
        LogViewCore.addLog(new LogItem(LogItem.Type.D, tag, System.currentTimeMillis(), msg));
    }

}
