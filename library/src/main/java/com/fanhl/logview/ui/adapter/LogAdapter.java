package com.fanhl.logview.ui.adapter;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanhl.logview.LogViewCore;
import com.fanhl.logview.R;
import com.fanhl.logview.model.LogItem;
import com.fanhl.logview.ui.base.ClickableRecyclerViewAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * A adapter to show log.
 * <p/>
 * Created by fanhl on 16/4/29.
 */
public class LogAdapter extends ClickableRecyclerViewAdapter<LogAdapter.ViewHolder> {

    /**
     * Use queue;so it has max size.
     */
    private final LinkedList<LogItem> queue;

    public LogAdapter(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
        queue = LogViewCore.getQueue();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.logview_item_log, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.bind(queue.get(position));
    }

    @Override
    public int getItemCount() {
        return queue.size();
    }

    //-----------------------数据增删相关-------------------------------
    @Deprecated
    public void AddItem(LogItem item) {
        int position = queue.size();
        queue.add(item);
        notifyItemInserted(position);
    }

    @Deprecated
    public void addItems(List<LogItem> items) {
        int positionStart = items.size();
        queue.addAll(items);
        notifyItemRangeInserted(positionStart, items.size());
    }

    @Deprecated
    public void clear() {
        int itemCount = queue.size();
        queue.clear();
        notifyItemRangeRemoved(0, itemCount);
    }

    public class ViewHolder extends ClickableRecyclerViewAdapter.ClickableViewHolder {

        private final TextView mLog;

        private LogItem data;

        public ViewHolder(View itemView) {
            super(itemView);
            mLog = ((TextView) itemView.findViewById(R.id.log));
        }

        public void bind(LogItem data) {
            mLog.setText(data.getLog());
            if (data.getType() == LogItem.Type.V) {
                mLog.setTextColor(getColor(R.color.logview_log_verbose));
            } else if (data.getType() == LogItem.Type.D) {
                mLog.setTextColor(getColor(R.color.logview_log_debug));
            } else if (data.getType() == LogItem.Type.I) {
                mLog.setTextColor(getColor(R.color.logview_log_info));
            } else if (data.getType() == LogItem.Type.W) {
                mLog.setTextColor(getColor(R.color.logview_log_warning));
            } else if (data.getType() == LogItem.Type.E) {
                mLog.setTextColor(getColor(R.color.logview_log_error));
            } else if (data.getType() == LogItem.Type.A) {
                mLog.setTextColor(getColor(R.color.logview_log_assert));
            }

            this.data = data;
        }

        private int getColor(@ColorRes int colorResId) {
            return itemView.getContext().getResources().getColor(colorResId);
        }

        public LogItem getData() {
            return data;
        }
    }
}
