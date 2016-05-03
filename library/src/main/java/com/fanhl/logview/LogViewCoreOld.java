package com.fanhl.logview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.fanhl.logview.constant.LogViewConstant;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.model.LogLevel;
import com.fanhl.logview.ui.fragment.LogFragment;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by fanhl on 16/5/1.
 */
public class LogViewCoreOld {
    private final static ArrayList<LogFragment> sActiveLogFragments;
    private final static LinkedList<LogItem>    sQueue;
    private final static LinkedList<LogItem>    sFilteredQueue;

    private static LogLevel sLevel = LogLevel.V;

    static {
        sActiveLogFragments = new ArrayList<>();
        sQueue = new LinkedList<>();
        sFilteredQueue = new LinkedList<>();
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

    static synchronized void addLog(LogItem object) {
        int positionStart = sQueue.size();
        sQueue.offer(object);
        for (LogFragment fragment : sActiveLogFragments) {
            fragment.notifyItemInserted(positionStart);
        }
        int overflowCount = sQueue.size() - LogViewConstant.LOG_QUEUE_MAX_SIZE;
        if (overflowCount > 0) {
            for (int i = 0; i < overflowCount; i++) {
                sQueue.poll();
            }
            for (LogFragment fragment : sActiveLogFragments) {
                fragment.notifyItemRangeRemoved(0, overflowCount);
            }
        }
    }

    public static void registerLogFragment(LogFragment fragment) {
        sActiveLogFragments.add(fragment);
    }

    public static void unregisterLogFragment(LogFragment fragment) {
        sActiveLogFragments.remove(fragment);
    }

    public static void setLogLevel(LogLevel level) {
        LogViewCoreOld.sLevel = level;
    }

    public static LinkedList<LogItem> getQueue() {
        return sQueue;
    }

    public static LinkedList<LogItem> getFilteredQueue() {
        return sFilteredQueue;
    }
}
