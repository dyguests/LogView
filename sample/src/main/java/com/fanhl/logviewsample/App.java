package com.fanhl.logviewsample;

import android.app.Application;

import com.fanhl.logview.LogViewApi;

/**
 * Created by fanhl on 16/4/30.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogViewApi.setEnable(true);
    }
}
