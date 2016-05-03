package com.fanhl.logview.ui.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.fanhl.logview.LogViewCore;
import com.fanhl.logview.R;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.model.LogLevel;
import com.fanhl.logview.ui.adapter.LogAdapter;
import com.fanhl.logview.ui.base.ClickableRecyclerViewAdapter;
import com.fanhl.logview.util.SystemUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhl on 16/5/1.
 */
public class LogContainerPresenter {
    public static final String TAG = LogContainerPresenter.class.getSimpleName();

    private final Context mContext;

    private final LinearLayout mContainer;
    private final RecyclerView mRecyclerView;
    private final Spinner      mTypeSpinner;

    private LogAdapter           mLogAdapter;
    private ArrayAdapter<String> mTypeAdapter;

    public LogContainerPresenter(Context context, View view) {
        mContext = context;

        mContainer = ((LinearLayout) view.findViewById(R.id.log_container));

        mRecyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        mTypeSpinner = ((Spinner) view.findViewById(R.id.type_spinner));
    }

    public void initData() {
        mLogAdapter = new LogAdapter(mContext, mRecyclerView);
        mRecyclerView.setAdapter(mLogAdapter);

        mLogAdapter.setOnItemClickListener(new ClickableRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ClickableRecyclerViewAdapter.ClickableViewHolder holder) {
                //copy log to clipboard.
                LogItem data = ((LogAdapter.ViewHolder) holder).getData();
                if (data != null) SystemUtil.copyToClipboard(mContext, data.getLog());

                // FIXME: 16/5/2 show detail.
            }
        });

        mTypeAdapter = new ArrayAdapter<>(mContext,
                android.R.layout.simple_spinner_dropdown_item,
                new String[]{"V", "D", "I", "W", "E", "A"});

        mTypeSpinner.setAdapter(mTypeAdapter);
        mTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LogViewCore.setLogLevel(LogLevel.values()[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Deprecated
    public void refreshData() {
        List<LogItem> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new LogItem(LogLevel.D, "TAG_MOCK", System.currentTimeMillis(), "aaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfaaaaaaaaaaaaaaasdfasdfa"));
        }
        mLogAdapter.addItems(list);
    }

    public void show() {
        mContainer.setVisibility(View.VISIBLE);
    }

    public void hide() {
        mContainer.setVisibility(View.GONE);
    }

    public void notifyItemInserted(int positionStart) {
        mLogAdapter.notifyItemInserted(positionStart);
    }

    public void notifyItemRangeRemoved(int positionStart, int itemCount) {
        mLogAdapter.notifyItemRangeRemoved(positionStart, itemCount);
    }
}
