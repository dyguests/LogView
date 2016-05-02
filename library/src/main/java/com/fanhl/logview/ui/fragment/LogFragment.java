package com.fanhl.logview.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.fanhl.logview.LogViewCore;
import com.fanhl.logview.R;
import com.fanhl.logview.ui.presenter.LogContainerPresenter;
import com.fanhl.logview.ui.presenter.TogglePresenter;

/**
 * A Fragment to show log.
 * Created by fanhl on 16/5/1.
 */
public class LogFragment extends Fragment {
    public static final String TAG = LogFragment.class.getSimpleName();

    private TogglePresenter       mTogglePresenter;
    private LogContainerPresenter mLogContainerPresenter;

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

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        LogViewCore.registerLogFragment(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogViewCore.unregisterLogFragment(this);
    }

    private void assignViews(View view) {
        mTogglePresenter = new TogglePresenter(view, new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mLogContainerPresenter.show();
                } else {
                    mLogContainerPresenter.hide();
                }
            }
        });
        mLogContainerPresenter = new LogContainerPresenter(getActivity(), view);
    }

    private void initData() {
        mLogContainerPresenter.initData();
    }

    private void refreshData() {
//        mLogContainerPresenter.refreshData();
    }

    public void notifyItemInserted(final int positionStart) {
        // FIXME: 16/5/2 change to SurfaceView or other later.because it will spend to mush ui thread.
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mLogContainerPresenter.notifyItemInserted(positionStart);
            }
        });
    }

    public void notifyItemRemoved(final int position) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mLogContainerPresenter.notifyItemRemoved(position);
            }
        });
    }
}
