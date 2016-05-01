package com.fanhl.logview.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * A TextView to show log by use textColor and background.
 * <p/>
 * fixme 这个最后实现
 * <p/>
 * Created by fanhl on 16/4/29.
 */
@Deprecated
public class LogTextView extends TextView {
    public LogTextView(Context context) {
        super(context);
    }

    public LogTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LogTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LogTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
