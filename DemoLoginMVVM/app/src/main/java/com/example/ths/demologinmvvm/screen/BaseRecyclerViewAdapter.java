package com.example.ths.demologinmvvm.screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ths on 17/05/2017.
 */

public abstract class BaseRecyclerViewAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {
    private final Context mContext;

    protected BaseRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    protected Context getContext() {
        return mContext;
    }

    public interface OnRecyclerViewItemClickListener<T> {
        void onItemRecyclerViewClick(T item);
    }
}
