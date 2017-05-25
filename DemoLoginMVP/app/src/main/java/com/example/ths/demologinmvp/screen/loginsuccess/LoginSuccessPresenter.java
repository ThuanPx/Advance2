package com.example.ths.demologinmvp.screen.loginsuccess;

import com.example.ths.demologinmvp.data.FriendsList;

import java.util.List;

/**
 * Created by ths on 16/05/2017.
 */

public class LoginSuccessPresenter implements LoginSuccessContract.Presenter,GetFriendComplete {
    private LoginSuccessContract.View mView;
    private AsyncTaskGetFriends mAsyncTaskGetFriends;

    public LoginSuccessPresenter() {
        mAsyncTaskGetFriends = new AsyncTaskGetFriends();
    }


    @Override
    public void getFriendsFb(String link) {
        mAsyncTaskGetFriends.setmGetFriendComplete(LoginSuccessPresenter.this);
        mAsyncTaskGetFriends.execute(link);
    }

    @Override
    public void setView(LoginSuccessContract.View view) {
        mView = view;
    }

    @Override
    public void getSuccess(List<FriendsList> friendsLists) {
        mView.getFriendsSuccess(friendsLists);
    }
}
