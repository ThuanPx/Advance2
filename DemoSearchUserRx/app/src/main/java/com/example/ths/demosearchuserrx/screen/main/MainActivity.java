package com.example.ths.demosearchuserrx.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import com.example.ths.demosearchuserrx.R;
import com.example.ths.demosearchuserrx.databinding.ActivityMainBinding;
import com.example.ths.demosearchuserrx.screen.widget.dialog.DialogManager;
import com.example.ths.demosearchuserrx.screen.widget.dialog.DialogManagerImpl;
import com.example.ths.demosearchuserrx.utils.navigator.Navigator;
import com.example.ths.demosearchuserrx.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;
    private CompositeDisposable mCompositeDisposable;
    private Navigator mNavigator ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        DialogManager dialogManager = new DialogManagerImpl(this);
        mCompositeDisposable = new CompositeDisposable();
        mNavigator =new Navigator(this);
        mMainViewModel = new MainViewModel(dialogManager,mNavigator);
        mMainViewModel.setSchedulerProvider(SchedulerProvider.getInstance());

        binding.setViewModel(mMainViewModel);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMainViewModel.onStop();
    }
}
