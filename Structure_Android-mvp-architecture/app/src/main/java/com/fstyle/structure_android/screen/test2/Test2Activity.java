package com.fstyle.structure_android.screen.test2;

import android.os.Bundle;
import com.fstyle.structure_android.R;
import com.fstyle.structure_android.screen.BaseActivity;

/**
 * Test2 Screen.
 */
public class Test2Activity extends BaseActivity implements Test2Contract.View {

    Test2Contract.Presenter  mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
		
	mPresenter = new Test2Presenter();
	mPresenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        mPresenter.onStop();
        super.onStop();
    }
}
