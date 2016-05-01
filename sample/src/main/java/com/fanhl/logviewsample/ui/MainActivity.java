package com.fanhl.logviewsample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fanhl.logview.LogViewApi;
import com.fanhl.logviewsample.R;
import com.fanhl.logviewsample.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private android.widget.Button button1;
    private android.widget.Button button2;
    private android.widget.Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogViewApi.bind(this);
        Log.d(TAG, "onCreate");

        assignViews();

    }

    private void assignViews() {
        this.button1 = (Button) findViewById(R.id.button1);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "button1 tapped!!!");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "button2 tapped!!!");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "button3 tapped!!!");
            }
        });
    }
}
