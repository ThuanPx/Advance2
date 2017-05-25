package com.example.ths.demologinmvvm.screen.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.ths.demologinmvvm.data.model.ObjectData;
import com.example.ths.demologinmvvm.screen.BaseViewModel;
import com.example.ths.demologinmvvm.screen.loginsuccess.LoginSuccessActivity;
import com.example.ths.demologinmvvm.utils.Constant;
import com.example.ths.demologinmvvm.utils.navigator.Navigator;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import java.util.Arrays;

/**
 * Created by ths on 17/05/2017.
 */

public class MainViewModel extends BaseViewModel  {
    private LoginButton mLoginButton;
    private CallbackManager mCallbackManager;
    private Navigator mNavigator;
    public MainViewModel(LoginButton loginButton, CallbackManager callbackManager,
            Navigator navigator) {
        mLoginButton = loginButton;
        mCallbackManager = callbackManager;
        mNavigator = navigator;

    }
    public void LoginButtonClicked(View view) {
        loginFacebook();
    }


    private void loginFacebook() {
        mLoginButton.setReadPermissions(
                (Arrays.asList("user_photos", "read_custom_friendlists", "user_friends")));
        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/taggable_friends", null,
                        HttpMethod.GET, new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        ObjectData objectData =
                                new Gson().fromJson(response.getRawResponse(), ObjectData.class);
                        gotoLoginSuccessActivity(objectData);
                    }
                }).executeAsync();
                Log.d("Login ", "Success -- "+AccessToken.getCurrentAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                LoginCancel();
            }

            @Override
            public void onError(FacebookException error) {
                LoginError();
            }
        });
    }

    private void gotoLoginSuccessActivity(ObjectData mObjectData) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.KEY_BUNDLE, mObjectData);
        mNavigator.startActivity(LoginSuccessActivity.class, bundle);
    }


}
