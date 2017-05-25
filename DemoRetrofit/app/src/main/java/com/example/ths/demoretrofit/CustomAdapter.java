package com.example.ths.demoretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ths on 11/05/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>  {
    private List<ItemProduct> mProductsList;
    private LayoutInflater mLayoutInflater;
    private Context context;

    public CustomAdapter(List<ItemProduct> mProductsList, Context context) {
        this.mProductsList = mProductsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mLayoutInflater==null){
            mLayoutInflater =LayoutInflater.from(parent.getContext());
        }
        View v = mLayoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
                holder.bindData(mProductsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mProductsList != null ? mProductsList.size():0   ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv);
            imageView= (ImageView) itemView.findViewById(R.id.im);
        }
        public void bindData(ItemProduct products){
            if(products==null) return;
                tv.setText(products.getFirst_name());
                Glide.with(context).load(products.getAvatar()).into(imageView);
        }
    }
}
