package com.fanhl.logviewsample.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fanhl.logview.LogViewApi;

/**
 * Created by fanhl on 16/5/5.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogViewApi.bind(this);
    }
}
