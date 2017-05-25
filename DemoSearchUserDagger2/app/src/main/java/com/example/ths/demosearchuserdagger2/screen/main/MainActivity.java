package com.example.ths.demosearchuserdagger2.screen.main;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.example.ths.demosearchuserdagger2.AppComponent;
import com.example.ths.demosearchuserdagger2.MainApplication;
import com.example.ths.demosearchuserdagger2.R;
import com.example.ths.demosearchuserdagger2.data.model.ListUser;
import com.example.ths.demosearchuserdagger2.data.model.User;
import com.example.ths.demosearchuserdagger2.screen.searchresult.SearchResultActivity;
import com.example.ths.demosearchuserdagger2.utils.Constant;
import com.example.ths.demosearchuserdagger2.utils.navigator.Navigator;
import dagger.internal.DaggerCollections;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    @Inject
    MainContract.Presenter mPresenter;
    @Inject
    Navigator mNavigator;
    private EditText etKey,etLimit;

    protected void onCreate(Bundle savedInstanceState) {
        DaggerMainComponent.builder()
                .appComponent(((MainApplication) getApplication()).getAppComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etKey = (EditText) findViewById(R.id.etKey);
        etLimit = (EditText) findViewById(R.id.etLimit);
    }

    @Override
    public void onSearchSuccess(List<User> users) {
       Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constant.KEY_BUNDLE, (ArrayList<? extends Parcelable>) users);
        mNavigator.startActivity(SearchResultActivity.class,bundle);
    }

    @Override
    public void onSearchError(Throwable throwable) {
        Log.d("Error",throwable.getLocalizedMessage());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }
    public void clickSearch(View view){
        mPresenter.searchUsers(Integer.parseInt(etLimit.getText().toString().trim()),etKey.getText().toString().trim());
    }
}
