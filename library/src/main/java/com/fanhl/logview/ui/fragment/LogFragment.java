package com.fanhl.logview.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanhl.logview.LogViewUI;
import com.fanhl.logview.R;

/**
 * Created by fanhl on 16/5/5.
 */
public class LogFragment extends Fragment {
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
        LogViewUI.registerLogFragment(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogViewUI.unregisterLogFragment(this);
    }

    private void assignViews(View view) {

    }

    private void initData() {

    }

    private void refreshData() {

    }
}
