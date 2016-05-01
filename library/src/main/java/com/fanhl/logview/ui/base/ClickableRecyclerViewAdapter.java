package com.fanhl.logview.ui.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhl on 2016/3/16.
 */
public abstract class ClickableRecyclerViewAdapter<CVH extends ClickableRecyclerViewAdapter.ClickableViewHolder> extends RecyclerView.Adapter<CVH> {

    protected Context context;

    protected RecyclerView mRecyclerView;
    protected List<RecyclerView.OnScrollListener> mListeners = new ArrayList<>();

    public ClickableRecyclerViewAdapter(Context context, RecyclerView recyclerView) {
        this.context = context;

        this.mRecyclerView = recyclerView;
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView rv, int newState) {
                for (RecyclerView.OnScrollListener listener : mListeners) {
                    listener.onScrollStateChanged(rv, newState);
                }
            }

            @Override
            public void onScrolled(RecyclerView rv, int dx, int dy) {
                for (RecyclerView.OnScrollListener listener : mListeners) {
                    listener.onScrolled(rv, dx, dy);
                }
            }
        });
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener listener) {
        mListeners.add(listener);
    }

    public interface OnItemClickListener {
        void onItemClick(int position, ClickableViewHolder holder);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(int position, ClickableViewHolder holder);
    }

    private OnItemClickListener     itemClickListener;
    private OnItemLongClickListener itemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.itemLongClickListener = listener;
    }

    @Override
    public void onBindViewHolder(final CVH holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position, holder);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return itemLongClickListener != null && itemLongClickListener.onItemLongClick(position, holder);
            }
        });
    }

    public static class ClickableViewHolder extends RecyclerView.ViewHolder {
        public ClickableViewHolder(View itemView) {
            super(itemView);
        }
    }

}