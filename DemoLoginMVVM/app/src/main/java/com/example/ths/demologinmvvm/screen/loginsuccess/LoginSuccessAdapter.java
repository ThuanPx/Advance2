package com.example.ths.demologinmvvm.screen.loginsuccess;

import android.content.Context;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ths.demologinmvvm.R;
import com.example.ths.demologinmvvm.data.model.data;
import com.example.ths.demologinmvvm.databinding.ItemLoginSuccessBinding;
import com.example.ths.demologinmvvm.databinding.ItemProgressbarBinding;
import com.example.ths.demologinmvvm.screen.BaseRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 18/05/2017.
 */

public class LoginSuccessAdapter extends BaseRecyclerViewAdapter<RecyclerView.ViewHolder> {

    private List<data> mDataList;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<data> mClickListener;
    public final int TYPE_FRIENDS = 0;
    public final int TYPE_LOAD = 1;
    boolean isLoading = false, isMoreDataAvailable = true;
    private OnLoadMoreListener mOnLoadMoreListener;
    public LoginSuccessAdapter(Context context) {
        super(context);
        mDataList = new ArrayList<>();
    }

    public void updateData(List<data> datas) {
        mDataList.clear();
        mDataList.addAll(datas);
        notifyDataSetChanged();
        isLoading =false;
    }

    public void setMoreDataAvailable(boolean moreDataAvailable) {
        isMoreDataAvailable = moreDataAvailable;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        mOnLoadMoreListener = onLoadMoreListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        ItemLoginSuccessBinding binding =
//                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
//
//                        R.layout.item_login_success, parent, false);
        if(viewType==TYPE_FRIENDS){
            ItemLoginSuccessBinding binding =
                            DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),

                                    R.layout.item_login_success, parent, false);
            Log.d("test","test type friends");
            return new ItemViewHolder(binding, mClickListener);
        }else{
            ItemProgressbarBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_progressbar,parent,false);
            Log.d("test","test type load");
            return  new ItemLoadMoreHolder(binding);
        }

//        return new ItemViewHolder(binding, mClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.bindData(mDataList.get(position));
        if(position>=getItemCount()-1 && isMoreDataAvailable && !isLoading&& mOnLoadMoreListener!=null){
            isLoading=true;
            mOnLoadMoreListener.onLoadMore();
        }
        if(getItemViewType(position)==TYPE_FRIENDS){
            ((ItemViewHolder)holder).bindData(mDataList.get(position));
            mOnLoadMoreListener.onStopLoadMore();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mDataList.get(position).getName().isEmpty()){
            return TYPE_LOAD;
        }else{
            return TYPE_FRIENDS;
        }
    }

    @Override
    public int getItemCount() {
        return mDataList != null ? mDataList.size() : 0;
    }

    public void setClickListener(OnRecyclerViewItemClickListener<data> clickListener) {
        mClickListener = clickListener;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private ItemLoginSuccessBinding mBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<data> mItemClickListener;

        public ItemViewHolder(ItemLoginSuccessBinding binding,
                BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<data> itemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemClickListener = itemClickListener;
        }

        public void bindData(data mData) {
            mBinding.setViewModel(new ItemLoginSuccessViewModel(mData, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
    static class ItemLoadMoreHolder extends RecyclerView.ViewHolder{
        private ItemProgressbarBinding mBinding;

        public ItemLoadMoreHolder(ItemProgressbarBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
