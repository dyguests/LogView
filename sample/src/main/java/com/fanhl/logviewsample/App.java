package com.fanhl.logviewsample;

import android.app.Application;

import com.fanhl.logview.LogViewApi;
import com.fanhl.logviewsample.util.Log;

/**
 * Created by fanhl on 16/4/30.
 */
public class App extends Application {
    public static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        LogViewApi.setEnable(true);
        Log.d(TAG, "LogViewApi.setEnable(true);");
    }
}
