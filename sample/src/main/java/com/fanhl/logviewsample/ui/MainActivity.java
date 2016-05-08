package com.fanhl.logviewsample.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.fanhl.logviewsample.R;
import com.fanhl.logviewsample.ui.base.BaseActivity;
import com.fanhl.logviewsample.util.Log;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");

        assignViews();
        initData();
        refreshData();
    }

    private void assignViews() {
        Log.w(TAG, "assignViews");

        findViewById(R.id.verbose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "button verbose tapped!!!");
            }
        });
        findViewById(R.id.debug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "button debug tapped!!!");
            }
        });
        findViewById(R.id.info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "button info tapped!!!");
            }
        });
        findViewById(R.id.warning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w(TAG, "button warning tapped!!!");
            }
        });
        findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "button error tapped!!!");
            }
        });
        findViewById(R.id.assert_).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.a(TAG, "button assert tapped!!!");
            }
        });
    }

    private void initData() {
        Log.e(TAG, "initData");
    }

    private void refreshData() {
        Log.a(TAG, "refreshData");
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "loop i:" + i + "/100");
                }
                return null;
            }
        }.execute();
    }
}
