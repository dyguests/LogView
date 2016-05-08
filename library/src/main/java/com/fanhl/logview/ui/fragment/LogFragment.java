package com.fanhl.logview.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.fanhl.logview.LogViewUI;
import com.fanhl.logview.R;

/**
 * Created by fanhl on 16/5/5.
 */
public class LogFragment extends Fragment {
    public static final String TAG = LogFragment.class.getSimpleName();

    private android.widget.ToggleButton            toggle;
    private android.widget.Spinner                 typespinner;
    private android.widget.EditText                editText;
    private android.support.v7.widget.RecyclerView recyclerview;
    private android.widget.LinearLayout            logcontainer;

    public static Fragment newInstance() {
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
        LogViewUI.registerLogFragment(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogViewUI.unregisterLogFragment(this);
    }

    private void assignViews(View view) {
        this.toggle = (ToggleButton) view.findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    logcontainer.setVisibility(View.VISIBLE);
                } else {
                    logcontainer.setVisibility(View.GONE);
                }
            }
        });
        this.logcontainer = (LinearLayout) view.findViewById(R.id.log_container);
        this.recyclerview = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.editText = (EditText) view.findViewById(R.id.editText);
        this.typespinner = (Spinner) view.findViewById(R.id.type_spinner);

    }

    private void initData() {

    }

    private void refreshData() {

    }
}
