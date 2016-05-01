package com.fanhl.logview.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanhl.logview.LogViewCore;
import com.fanhl.logview.R;
import com.fanhl.logview.model.LogItem;

import java.util.LinkedList;
import java.util.List;

/**
 * A adapter to show log.
 * <p/>
 * Created by fanhl on 16/4/29.
 */
public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {

    private final Context             context;
    private final LinkedList<LogItem> list;

    public LogAdapter(Context context) {
        this.context = context;
        list = LogViewCore.getQueue();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.logview_item_log, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //-----------------------数据增删相关-------------------------------
    @Deprecated
    public void AddItem(LogItem item) {
        int position = list.size();
        list.add(item);
        notifyItemInserted(position);
    }

    @Deprecated
    public void addItems(List<LogItem> items) {
        int positionStart = items.size();
        list.addAll(items);
        notifyItemRangeInserted(positionStart, items.size());
    }

    @Deprecated
    public void clear() {
        int itemCount = list.size();
        list.clear();
        notifyItemRangeRemoved(0, itemCount);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mLog;

        private LogItem data;

        public ViewHolder(View itemView) {
            super(itemView);
            mLog = ((TextView) itemView.findViewById(R.id.log));
        }

        public void bind(LogItem data) {
            mLog.setText(data.getLog());
            this.data = data;

        }

        public LogItem getData() {
            return data;
        }
    }
}
