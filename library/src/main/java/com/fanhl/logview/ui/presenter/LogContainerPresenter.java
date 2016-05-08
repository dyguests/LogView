package com.fanhl.logview.ui.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.fanhl.logview.R;

/**
 * Created by fanhl on 16/5/8.
 */
public class LogContainerPresenter {

    private Spinner      typespinner;
    private EditText     editText;
    private RecyclerView recyclerview;
    private LinearLayout logcontainer;

    public LogContainerPresenter(View view) {
        this.logcontainer = (LinearLayout) view.findViewById(R.id.log_container);

        this.typespinner = (Spinner) view.findViewById(R.id.type_spinner);
        this.editText = (EditText) view.findViewById(R.id.editText);

        this.recyclerview = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    public void initData() {
//recyclerview.setAdapter();
    }

    public void setVisible(boolean visible) {
        if (visible) logcontainer.setVisibility(View.VISIBLE);
        else logcontainer.setVisibility(View.GONE);
    }
}
