package com.fanhl.logview.ui.presenter;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.fanhl.logview.R;

/**
 * A toggle button to show/hide log.
 * Created by fanhl on 16/5/1.
 */
public class TogglePresenter {

    private final ToggleButton mToggle;

    public TogglePresenter(View view, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        mToggle = ((ToggleButton) view.findViewById(R.id.log_toggle));
        mToggle.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
