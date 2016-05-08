package com.fanhl.logview.ui.presenter;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.fanhl.logview.R;

/**
 * Created by fanhl on 16/5/8.
 */
public class TogglePresenter {
    private ToggleButton toggle;

    public TogglePresenter(View view, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.toggle = (ToggleButton) view.findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
