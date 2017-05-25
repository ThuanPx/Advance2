package com.example.ths.demologinmvvm.screen.loginsuccess;

import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;
import com.example.ths.demologinmvvm.data.model.data;
import com.example.ths.demologinmvvm.screen.BaseRecyclerViewAdapter;
import java.util.List;

/**
 * Created by ths on 17/05/2017.
 */

public class ItemLoginSuccessViewModel extends BaseObservable {
    private data mData;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<data> mItemClickListener;

    public ItemLoginSuccessViewModel(data data, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<data> itemClickListener) {
        mData = data;
        mItemClickListener = itemClickListener;
    }

    public void onItemClicked(View view) {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mData);

    }

    public String getDataName() {
        return mData.getName();
    }
    public String getDataImage(){
        return mData.getPicture().getDataPicture().getUrl();
    }
}
