package com.example.ths.demologinmvvm.screen.loginsuccess;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.example.ths.demologinmvvm.R;
import com.example.ths.demologinmvvm.data.model.ObjectData;
import com.example.ths.demologinmvvm.data.model.data;
import com.example.ths.demologinmvvm.databinding.ActivityLoginSuccessBinding;
import com.example.ths.demologinmvvm.utils.Constant;
import com.example.ths.demologinmvvm.utils.navigator.Navigator;
import java.util.List;

public class LoginSuccessActivity extends AppCompatActivity {
    private LoginSuccessViewModel mLoginSuccessViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObjectData mObjectData;
        Bundle bundle  = getIntent().getExtras();
        mObjectData = bundle.getParcelable(Constant.KEY_BUNDLE);

        Navigator navigator = new Navigator(this);
        LoginSuccessAdapter mLoginSuccessAdapter = new LoginSuccessAdapter(this);
        mLoginSuccessViewModel = new LoginSuccessViewModel(mObjectData,navigator,mLoginSuccessAdapter);

        ActivityLoginSuccessBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login_success);


        binding.setViewModel(mLoginSuccessViewModel);
    }
}
