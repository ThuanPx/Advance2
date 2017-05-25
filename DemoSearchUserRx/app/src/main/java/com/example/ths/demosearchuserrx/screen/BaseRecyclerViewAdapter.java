package com.example.ths.demosearchuserrx.screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ths on 19/05/2017.
 */

public abstract class BaseRecyclerViewAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {
    private Context mContext;

    public Context getContext() {
        return mContext;
    }

    public BaseRecyclerViewAdapter(Context context) {
        mContext = context;
    }
    public interface OnRecyclerViewOnClickListener<T>{
        void onItemRecyclerViewClick(T item);
    }
}
