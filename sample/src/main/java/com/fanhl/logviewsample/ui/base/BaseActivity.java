package com.fanhl.logviewsample.ui.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.fanhl.logview.LogViewApi;

/**
 * Created by fanhl on 16/5/5.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        LogViewApi.bind(this);
    }

    @Override public void setContentView(View view) {
        super.setContentView(view);
        LogViewApi.bind(this);
    }

    @Override public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        LogViewApi.bind(this);
    }
}
