package com.example.ths.demologinmvp.screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ths on 13/05/2017.
 */

public abstract class BaseRecyclerViewAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    private final Context context;

    protected BaseRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    protected Context getContext() {
        return context;
    }
}
