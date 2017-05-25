package com.example.ths.demosearchuserrx.screen.searhresult;

import android.databinding.BaseObservable;
import android.util.Log;
import com.example.ths.demosearchuserrx.data.model.ListUser;
import com.example.ths.demosearchuserrx.data.model.User;
import com.example.ths.demosearchuserrx.screen.BaseRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 22/05/2017.
 */

public class SearchResultViewModel extends BaseObservable implements BaseRecyclerViewAdapter.OnRecyclerViewOnClickListener<User> {

    private SearchResultAdapter mSearchResultAdapter;
    private List<User> mUserList;
    private ListUser User;

    public SearchResultViewModel(SearchResultAdapter searchResultAdapter, ListUser user) {
        mSearchResultAdapter = searchResultAdapter;
        User = user;
        mUserList =new ArrayList<>();
        mUserList.addAll(User.getUserList());
        mSearchResultAdapter.updateData(mUserList);
        mSearchResultAdapter.setClickListener(this);
    }

    public SearchResultAdapter getAdapter(){
        return mSearchResultAdapter;
    }


    @Override
    public void onItemRecyclerViewClick(User item) {
        Log.d("Tst",item.getImageUrl());
    }
}
