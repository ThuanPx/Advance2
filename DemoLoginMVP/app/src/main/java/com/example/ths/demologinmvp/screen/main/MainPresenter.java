package com.example.ths.demologinmvp.screen.main;

import com.example.ths.demologinmvp.data.FriendsList;
import com.example.ths.demologinmvp.data.FriendsListData;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ths on 12/05/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";

    private MainContract.View mMainView;
    private List<FriendsList> mFriendsLists;
    public MainPresenter() {

    }


    @Override
    public void loginFacebook(LoginButton loginButton, CallbackManager callbackManager) {
        loginButton.setReadPermissions((Arrays.asList("user_photos", "read_custom_friendlists", "user_friends")));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                new GraphRequest(
                        AccessToken.getCurrentAccessToken(),
                        "/me/taggable_friends",
                        null,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                FriendsListData friendsListData = new Gson().fromJson(response.getRawResponse(), FriendsListData.class);
//                                mFriendsLists.addAll(friendsListData.getFriends());
                                    mMainView.loginSuccess(friendsListData);
//                                mAsyncTaskGetFriends.execute(friendsListData.getPaging().getNext());
//                                mAsyncTaskGetFriends.setmGetFriendComplete(MainPresenter.this);
                            }
                        }
                ).executeAsync();


            }

            @Override
            public void onCancel() {
                mMainView.loginError();
            }

            @Override
            public void onError(FacebookException error) {
                mMainView.loginError();
            }
        });

    }


    @Override
    public void setView(MainContract.View view) {
        mMainView = view;
    }


}
