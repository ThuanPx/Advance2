package com.example.ths.demosearchuserdagger2.screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ths on 23/05/2017.
 */

public abstract class BaseRecyclerViewAdapter <V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {
    private final Context mContext;

    public Context getContext() {
        return mContext;
    }

    public BaseRecyclerViewAdapter(Context context) {
        mContext = context;
    }
}
