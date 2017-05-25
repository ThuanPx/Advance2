package com.example.ths.demologinmvvm.screen.loginsuccess;

import android.app.ProgressDialog;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;
import com.example.ths.demologinmvvm.BR;
import com.example.ths.demologinmvvm.data.model.ObjectData;
import com.example.ths.demologinmvvm.data.model.data;
import com.example.ths.demologinmvvm.screen.BaseRecyclerViewAdapter;
import com.example.ths.demologinmvvm.screen.BaseViewModel;
import com.example.ths.demologinmvvm.utils.navigator.Navigator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 17/05/2017.
 */

public class LoginSuccessViewModel extends BaseViewModel
        implements BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<data>,
        GetFriendsListener,OnLoadMoreListener {
    private LoginSuccessAdapter mLoginSuccessAdapter;
    private Navigator mNavigator;
    private ObjectData mObjectData;
    private List<data> mDataList;
    private AsyncTaskGetFriends mAsyncTaskGetFriends;
    private ProgressDialog mProgressDialog;
    private String pagingNext;
    private boolean isLoading;
    public LoginSuccessViewModel(ObjectData objectData, Navigator navigator,
            LoginSuccessAdapter loginSuccessAdapter) {
        mNavigator = navigator;
        mObjectData = objectData;
        mDataList = new ArrayList<>();
        mDataList.addAll(mObjectData.getData());
        mLoginSuccessAdapter = loginSuccessAdapter;
        mAsyncTaskGetFriends = new AsyncTaskGetFriends();
        mLoginSuccessAdapter.setClickListener(this);

        mLoginSuccessAdapter.setOnLoadMoreListener(this);
        pagingNext = null;
        mAsyncTaskGetFriends.setGetFriendsListener(LoginSuccessViewModel.this);

    }

    public void clickGetFriends(View view) {
//       setLoading(true);
         mAsyncTaskGetFriends.execute(mObjectData.getPaging().getNext());
    }
    @Bindable
    public boolean isLoading() {
        return isLoading;

    }
    public void setLoading(boolean loading) {
        isLoading = loading;
        notifyPropertyChanged(BR.loading);
    }

    public LoginSuccessAdapter getAdapter() {
        return mLoginSuccessAdapter;
    }

    @Override
    public void onItemRecyclerViewClick(data item) {
        mNavigator.Toast(item.getName());
    }

    @Override
    public void getFriendsSuccess(List<data> dataList) {
        mDataList.addAll(dataList);
        mLoginSuccessAdapter.updateData(mDataList);
    }

    @Override
    public void getPageNext(String next) {
        pagingNext=next;
    }

    @Override
    public void showDialog() {
        mProgressDialog = new ProgressDialog(mNavigator.getActivity());
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
    }

    @Override
    public void hideDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onLoadMore() {
        setLoading(true);
        mAsyncTaskGetFriends = new AsyncTaskGetFriends();
        mAsyncTaskGetFriends.setGetFriendsListener(this);
        mAsyncTaskGetFriends.execute(pagingNext);

    }

    @Override
    public void onStopLoadMore() {
        setLoading(false);
    }
}
