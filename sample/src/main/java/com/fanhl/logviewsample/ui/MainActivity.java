package com.fanhl.logviewsample.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fanhl.logviewsample.R;
import com.fanhl.logviewsample.ui.base.BaseActivity;
import com.fanhl.logviewsample.util.Log;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private android.widget.Button button1;
    private android.widget.Button button2;
    private android.widget.Button button3;

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
        this.button1 = (Button) findViewById(R.id.button1);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w(TAG, "button1 tapped!!!");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "button2 tapped!!!");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.a(TAG, "button3 tapped!!!");
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
