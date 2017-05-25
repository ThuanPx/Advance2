package com.example.ths.demologinmvp.screen.loginsuccess;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ths.demologinmvp.R;
import com.example.ths.demologinmvp.data.FriendsList;
import com.example.ths.demologinmvp.screen.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * Created by ths on 13/05/2017.
 */

public class ListFriendAdapter extends BaseRecyclerViewAdapter<ListFriendAdapter.ItemViewHolder> {
    private List<FriendsList> mList;
    private LayoutInflater mLayoutInflater;
    public ListFriendAdapter(Context context, List<FriendsList> mListc) {
        super(context);
        this.mList =  mListc;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mLayoutInflater==null){
            mLayoutInflater =LayoutInflater.from(parent.getContext());
        }
        View view = mLayoutInflater.inflate(R.layout.item_row,parent,false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList!= null? mList.size():0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private ImageView im;
        public ItemViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            im = (ImageView) itemView.findViewById(R.id.im);
        }

        public void setData(FriendsList user){
            tv.setText(user.getName());
            Glide.with(getContext()).load(user.getmPicture().getmDataUrl().getImageUrl().toString()).placeholder(R.drawable.androidify).into(im);
        }
    }
}
