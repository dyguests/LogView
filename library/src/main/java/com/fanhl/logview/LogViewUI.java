package com.fanhl.logview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.fanhl.logview.ui.fragment.LogFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * UI
 * <p/>
 * Created by fanhl on 16/5/4.
 */
public class LogViewUI {
    public static final String TAG = LogViewUI.class.getSimpleName();

    private final static List<LogFragment> activeLogFragments;

    static {
        activeLogFragments = new ArrayList<>();
    }

    public static void bind(Activity activity) {
        View view = LayoutInflater.from(activity).inflate(R.layout.logview_container, null);
//        activity.addContentView(view, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        activity.getWindowManager().addView(view, new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
    }

    public static void registerLogFragment(LogFragment logFragment) {
        activeLogFragments.add(logFragment);
    }

    public static void unregisterLogFragment(LogFragment logFragment) {
        activeLogFragments.remove(logFragment);
    }
}
