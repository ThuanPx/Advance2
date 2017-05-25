package com.example.ths.demosearchuserrx.screen.searhresult;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ths.demosearchuserrx.R;
import com.example.ths.demosearchuserrx.data.model.User;
import com.example.ths.demosearchuserrx.databinding.ItemSearchResultBinding;
import com.example.ths.demosearchuserrx.screen.BaseRecyclerViewAdapter;
import com.example.ths.demosearchuserrx.utils.binding.BindingUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 22/05/2017.
 */

public class SearchResultAdapter extends BaseRecyclerViewAdapter<SearchResultAdapter.ItemViewHolder>  {
    private List<User> mUserList;
    private BaseRecyclerViewAdapter.OnRecyclerViewOnClickListener mClickListener;
    public SearchResultAdapter(Context context) {
        super(context);
        mUserList = new ArrayList<>();
    }
    public void updateData(List<User> user){
        mUserList.clear();
        mUserList.addAll(user);
        notifyDataSetChanged();
    }

    public void setClickListener(OnRecyclerViewOnClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSearchResultBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),

                R.layout.item_search_result,parent,false);
        return new ItemViewHolder(binding,mClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
                holder.bindData(mUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserList!=null?mUserList.size():0;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private ItemSearchResultBinding mBinding ;
        private BaseRecyclerViewAdapter.OnRecyclerViewOnClickListener mClickListener;

        public ItemViewHolder( ItemSearchResultBinding binding,
                BaseRecyclerViewAdapter.OnRecyclerViewOnClickListener clickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mClickListener = clickListener;
        }
        public void bindData(User mUser ){
            mBinding.setViewModel(new ItemSearchResultViewModel(mUser,mClickListener));
            mBinding.executePendingBindings();
        }
    }
}
