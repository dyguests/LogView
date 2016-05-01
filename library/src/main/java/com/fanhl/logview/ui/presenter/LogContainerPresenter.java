package com.fanhl.logview.ui.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fanhl.logview.R;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.ui.adapter.LogAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhl on 16/5/1.
 */
public class LogContainerPresenter {

    private final Context mContext;

    private final LinearLayout mContainer;
    private final RecyclerView mRecyclerView;
    private final Button       mHide;

    private LogAdapter mAdapter;

    public LogContainerPresenter(Context context, View view, final Callback callback) {
        mContext = context;

        mContainer = ((LinearLayout) view.findViewById(R.id.log_container));

        mHide = ((Button) view.findViewById(R.id.hide));
        mHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                callback.onHideClick();
            }
        });

        mRecyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
    }

    public void initData() {
        mAdapter = new LogAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Deprecated
    public void refreshData() {
        List<LogItem> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new LogItem(LogItem.Type.D, "TAG_MOCK", System.currentTimeMillis(), "aaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfa"));
        }
        mAdapter.addItems(list);
    }

    public void show() {
        mContainer.setVisibility(View.VISIBLE);
    }

    private void hide() {
        mContainer.setVisibility(View.GONE);
    }

    public boolean isVisible() {
        return mContainer.getVisibility() == View.VISIBLE;
    }

    public void notifyLogInsert(int positionStart) {
        mAdapter.notifyItemInserted(positionStart);
    }

    public interface Callback {
        void onHideClick();
    }
}
