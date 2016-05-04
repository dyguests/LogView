package com.fanhl.logview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by fanhl on 16/5/4.
 */
public class LogViewUI {
    public static void bind(Activity activity) {
        View        view     = LayoutInflater.from(activity).inflate(R.layout.logview_fragment_log, null);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override public void onViewAttachedToWindow(View v) {

            }

            @Override public void onViewDetachedFromWindow(View v) {

            }
        });

        activity.getWindowManager().addView(view, new WindowManager.LayoutParams());
    }
}
