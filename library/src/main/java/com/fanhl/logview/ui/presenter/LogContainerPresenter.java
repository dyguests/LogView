package com.fanhl.logview.ui.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.fanhl.logview.R;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.ui.adapter.LogAdapter;
import com.fanhl.logview.ui.base.ClickableRecyclerViewAdapter;
import com.fanhl.logview.util.SystemUtil;

/**
 * Created by fanhl on 16/5/8.
 */
public class LogContainerPresenter {

    private LinearLayout logContainer;
    private Spinner      typeSpinner;
    private EditText     editText;
    private RecyclerView recyclerView;

    private LogAdapter adapter;

    public LogContainerPresenter(View view) {
        this.logContainer = (LinearLayout) view.findViewById(R.id.log_container);

        this.typeSpinner = (Spinner) view.findViewById(R.id.type_spinner);
        this.editText = (EditText) view.findViewById(R.id.editText);

        this.recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    public void initData() {
        adapter = new LogAdapter(recyclerView.getContext(), recyclerView);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ClickableRecyclerViewAdapter.OnItemClickListener() {
            @Override public void onItemClick(int position, ClickableRecyclerViewAdapter.ClickableViewHolder holder) {
                LogItem data = ((LogAdapter.ViewHolder) holder).getData();
                SystemUtil.copyToClipboard(recyclerView.getContext(), data.getLog());
            }
        });
    }

    public void setVisible(boolean visible) {
        if (visible) logContainer.setVisibility(View.VISIBLE);
        else logContainer.setVisibility(View.GONE);
    }

    public void refreshData() {
        adapter.notifyDataSetChanged();
    }
}
