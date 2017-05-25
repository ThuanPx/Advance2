package com.example.ths.demosearchuserrx.screen.searhresult;

import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.view.View;
import com.example.ths.demosearchuserrx.data.model.User;
import com.example.ths.demosearchuserrx.screen.BaseRecyclerViewAdapter;
import com.example.ths.demosearchuserrx.screen.BaseViewModel;

/**
 * Created by ths on 22/05/2017.
 */

public class ItemSearchResultViewModel extends BaseObservable {
    private User mUser;
    private BaseRecyclerViewAdapter.OnRecyclerViewOnClickListener<User> mClickListener;

    public ItemSearchResultViewModel(User user,
            BaseRecyclerViewAdapter.OnRecyclerViewOnClickListener<User> clickListener) {
        mUser = user;
        mClickListener = clickListener;
    }
    public void onItemClicked(View view){
        if(mClickListener ==null)return;
        mClickListener.onItemRecyclerViewClick(mUser);
    }
    public String getUserName(){
        return mUser.getLogin();
    }

    public String getUserImage(){
        return mUser.getImageUrl();
    }
}
