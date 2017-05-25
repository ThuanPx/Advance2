package com.fstyle.structure_android.screen.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.fstyle.structure_android.R;
import com.fstyle.structure_android.databinding.ActivityTestBinding;
import com.fstyle.structure_android.screen.BaseActivity;

/**
 * Test Screen.
 */
public class TestActivity extends BaseActivity {

    private TestViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new TestViewModel();
        ActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
