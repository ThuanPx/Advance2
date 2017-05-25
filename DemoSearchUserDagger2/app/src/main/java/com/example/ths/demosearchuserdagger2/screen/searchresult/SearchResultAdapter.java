package com.example.ths.demosearchuserdagger2.screen.searchresult;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ths.demosearchuserdagger2.R;
import com.example.ths.demosearchuserdagger2.data.model.User;
import com.example.ths.demosearchuserdagger2.screen.BaseRecyclerViewAdapter;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 23/05/2017.
 */

public class SearchResultAdapter extends BaseRecyclerViewAdapter<SearchResultAdapter.ItemViewHolder> {
    private List<User> mUsers;
    private Context mContext;

    public SearchResultAdapter(Context context, List<User> users) {
        super(context);
        mUsers= new ArrayList<>();
        mUsers.addAll(users);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_row,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
                holder.binData(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers!=null?mUsers.size():0;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private ImageView iv1;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            iv1 = (ImageView) itemView.findViewById(R.id.iv1);
        }
        public void binData(User user){
            tv1.setText(user.getLogin());
            Picasso.with(itemView.getContext()).load(user.getImageUrl()).placeholder(R.drawable.androidify).into(iv1);
        }
    }
}
