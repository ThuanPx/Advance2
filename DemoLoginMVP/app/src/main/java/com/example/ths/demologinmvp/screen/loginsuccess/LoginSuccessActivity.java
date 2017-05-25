package com.example.ths.demologinmvp.screen.loginsuccess;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ths.demologinmvp.R;
import com.example.ths.demologinmvp.data.FriendsList;
import com.example.ths.demologinmvp.data.FriendsListData;

import java.util.ArrayList;
import java.util.List;

public class LoginSuccessActivity extends Activity implements LoginSuccessContract.View {
    FriendsListData mPagingEntity;
    private RecyclerView recyclerView;
    private List<FriendsList> userList;
    private ListFriendAdapter adapter;
    private LoginSuccessContract.Presenter mPresenter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Bundle bundle = getIntent().getExtras();
        mPagingEntity = bundle.getParcelable("dataNext");
        initView();
        mPresenter2 = new LoginSuccessPresenter();
        mPresenter2.setView(this);
         findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.d("tha",mPagingEntity.getPaging().getNext());
                 mPresenter2.getFriendsFb(mPagingEntity.getPaging().getNext());
             }
         });

    }

    private void initView() {
        userList = new ArrayList<>();
        adapter = new ListFriendAdapter(getApplicationContext(), userList);
        recyclerView = (RecyclerView) findViewById(R.id.rv_listfriends);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }


    @Override
    public void getFriendsSuccess(List<FriendsList> friendsLists) {
        userList.addAll(friendsLists);
        adapter.notifyItemInserted(0);
        recyclerView.scrollToPosition(0);
    }
}
