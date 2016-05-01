package com.fanhl.logview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.fanhl.logview.ui.adapter.LogFragment;

/**
 * Created by fanhl on 16/4/29.
 */
public class LogViewApi {

    private static boolean enable;

    public static void bind(Activity activity) {
        if (!enable) return;
        FrameLayout logContainer = new FrameLayout(activity);
        logContainer.setId(2012345);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        activity.addContentView(logContainer, layoutParams);

        activity.getFragmentManager()
                .beginTransaction()
                .add(logContainer.getId(), LogFragment.newInstance(), LogFragment.TAG)
                .commit();
    }

    public static void setEnable(boolean enable) {
        LogViewApi.enable = enable;
    }

    public static void d(String tag, String msg) {
        if (!enable) return;
        LogViewCore.addDebugLog(tag, msg);
    }

}
