package com.example.ths.demologinmvp.screen.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ths.demologinmvp.R;
import com.example.ths.demologinmvp.data.FriendsListData;
import com.example.ths.demologinmvp.screen.loginsuccess.LoginSuccessActivity;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainContract.Presenter mPresenter;

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter();
        mPresenter.setView(this);

        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);

        mPresenter.loginFacebook(loginButton,callbackManager);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public void loginSuccess(FriendsListData friendsListData) {
        Log.d("123",friendsListData.getPaging().getNext());
        Intent intent = new Intent(MainActivity.this, LoginSuccessActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("dataNext",friendsListData);
        intent.putExtras(bundle);
        startActivity(intent);



//        userList.addAll(mFriendsLists);
//        adapter.notifyItemInserted(0);
//        recyclerView.scrollToPosition(0);
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Đăng nhập không thành công !", Toast.LENGTH_SHORT).show();
    }




}
