package com.fanhl.logview;

import android.app.Activity;
import android.view.WindowManager;
import android.widget.RelativeLayout;

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

        LogCore.setCallback(new LogCore.Callback() {
            @Override public void onFilteredLogsChanged() {
                notifyLogsChanged();
            }

            @Override public void onLogFilterConditionChanged() {
                notifyLogsChanged();
            }
        });
    }

    public static void bind(Activity activity) {
        RelativeLayout logContainer = new RelativeLayout(activity);
        logContainer.setId(2012345);

        activity.getWindow().addContentView(logContainer, new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));

        activity.getFragmentManager()
                .beginTransaction()
                .add(logContainer.getId(), LogFragment.newInstance(), LogFragment.TAG)
                .commit();
    }

    public static void registerLogFragment(LogFragment logFragment) {
        activeLogFragments.add(logFragment);
    }

    public static void unregisterLogFragment(LogFragment logFragment) {
        activeLogFragments.remove(logFragment);
    }

    private static void notifyLogsChanged() {
        for (final LogFragment logFragment : activeLogFragments) {
            logFragment.getActivity().runOnUiThread(new Runnable() {
                @Override public void run() {
                    logFragment.notifyLogsChanged();
                }
            });
        }
    }
}
