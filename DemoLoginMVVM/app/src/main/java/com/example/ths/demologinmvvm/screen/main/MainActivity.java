package com.example.ths.demologinmvvm.screen.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ths.demologinmvvm.R;
import com.example.ths.demologinmvvm.databinding.ActivityMainBinding;
import com.example.ths.demologinmvvm.utils.navigator.Navigator;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity   {
    private CallbackManager mCallbackManager;
    private MainViewModel mMainViewModel;
    private LoginButton mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Navigator navigator = new Navigator(this);
        mCallbackManager = CallbackManager.Factory.create();
        mLoginButton = (LoginButton) findViewById(R.id.login_button);
        mMainViewModel = new MainViewModel(mLoginButton,mCallbackManager,navigator);

        binding.setViewModel(mMainViewModel);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
