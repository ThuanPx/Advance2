package com.fstyle.structure_android.screen.test2;

/**
 * Listens to user actions from the UI ({@link Test2Activity}), retrieves the data and updates
 * the UI as required.
 */
final class Test2Presenter implements Test2Contract.Presenter {
	private static final String TAG = Test2Presenter.class.getName();

    private Test2Contract.View mView;

    public Test2Presenter() {
    }

    @Override
    public void setView(Test2Contract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
