package com.fanhl.logview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.ui.fragment.LogFragment;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by fanhl on 16/5/1.
 */
public class LogViewCore {
    private static final int LOG_QUEUE_MAX_SIZE = 1000;
    private static ArrayList<LogFragment> sActiveLogFragments;

    private final static LinkedList<LogItem> sQueue;

    static {
        sActiveLogFragments = new ArrayList<>();
        sQueue = new LinkedList<>();
    }

    static void bind(Activity activity) {
        FrameLayout logContainer = new FrameLayout(activity);
        logContainer.setId(2012345);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        activity.addContentView(logContainer, layoutParams);

        activity.getFragmentManager()
                .beginTransaction()
                .add(logContainer.getId(), LogFragment.newInstance(), LogFragment.TAG)
                .commit();
    }

    static void addLog(LogItem object) {
        int positionStart = sQueue.size();
        sQueue.offer(object);
        for (LogFragment fragment : sActiveLogFragments) {
            fragment.notifyItemInserted(positionStart);
        }
        if (sQueue.size() > LOG_QUEUE_MAX_SIZE) {
            sQueue.poll();
            for (LogFragment fragment : sActiveLogFragments) {
                fragment.notifyItemRemoved(0);
            }
        }
    }

    public static void registerLogFragment(LogFragment fragment) {
        sActiveLogFragments.add(fragment);
    }

    public static void unregisterLogFragment(LogFragment fragment) {
        sActiveLogFragments.remove(fragment);
    }

    public static LinkedList<LogItem> getQueue() {
        return sQueue;
    }
}
