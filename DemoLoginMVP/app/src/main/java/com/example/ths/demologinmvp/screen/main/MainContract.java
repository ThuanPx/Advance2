package com.example.ths.demologinmvp.screen.main;

import com.example.ths.demologinmvp.data.FriendsList;
import com.example.ths.demologinmvp.data.FriendsListData;
import com.example.ths.demologinmvp.screen.BasePresenter;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by ths on 12/05/2017.
 */

public interface MainContract {
    interface View {
        void loginSuccess(FriendsListData friendsListData);
        void loginError();


    }

    interface Presenter extends BasePresenter<View> {

        void loginFacebook(LoginButton loginButton,CallbackManager callbackManager);

    }
}
