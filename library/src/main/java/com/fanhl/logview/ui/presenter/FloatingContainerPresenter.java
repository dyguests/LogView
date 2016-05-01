package com.fanhl.logview.ui.presenter;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.fanhl.logview.R;

/**
 * Created by fanhl on 16/5/1.
 */
public class FloatingContainerPresenter {

    private final FrameLayout mContainer;
    private final Button      mShow;

    public FloatingContainerPresenter(View view, final Callback callback) {
        mContainer = ((FrameLayout) view.findViewById(R.id.floating_container));
        mShow = ((Button) view.findViewById(R.id.floating_show));
        mShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                callback.onShowClick();
            }
        });
    }

    public void show() {
        mContainer.setVisibility(View.VISIBLE);
    }

    private void hide() {
        mContainer.setVisibility(View.GONE);
    }

    public interface Callback {
        void onShowClick();
    }
}
