package com.fanhl.logview.ui.adapter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanhl.logview.R;
import com.fanhl.logview.ui.presenter.FloatingContainerPresenter;
import com.fanhl.logview.ui.presenter.LogContainerPresenter;

/**
 * A Fragment to show log.
 * Created by fanhl on 16/5/1.
 */
public class LogFragment extends Fragment {
    public static final String TAG = LogFragment.class.getSimpleName();

    private FloatingContainerPresenter mFloatingContainerPresenter;
    private LogContainerPresenter      mLogContainerPresenter;

    public static LogFragment newInstance() {
        return new LogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.logview_fragment_log, container, false);
        assignViews(view);
        initData();
        refreshData();
        return view;
    }

    private void assignViews(View view) {
        mFloatingContainerPresenter = new FloatingContainerPresenter(view, new FloatingContainerPresenter.Callback() {
            @Override
            public void onShowClick() {
                mLogContainerPresenter.show();
            }
        });
        mLogContainerPresenter = new LogContainerPresenter(getActivity(), view, new LogContainerPresenter.Callback() {
            @Override
            public void onHideClick() {
                mFloatingContainerPresenter.show();
            }
        });
    }

    private void initData() {
        mLogContainerPresenter.initData();
    }

    private void refreshData() {
        mLogContainerPresenter.refreshData();
    }
}
