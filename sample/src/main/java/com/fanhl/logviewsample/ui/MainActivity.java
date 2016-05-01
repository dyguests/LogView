package com.fanhl.logviewsample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fanhl.logview.LogViewApi;
import com.fanhl.logviewsample.R;
import com.fanhl.logviewsample.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogViewApi.bind(this);

        Log.d(TAG, "");
    }
}
