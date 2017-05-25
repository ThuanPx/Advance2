package com.fstyle.structure_android.screen.test2;

import com.fstyle.structure_android.screen.BasePresenter;
import com.fstyle.structure_android.screen.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
interface Test2Contract {
	/**
	 * View.
	 */
    interface View extends BaseView {
    }
	
	/**
	 * Presenter.
	 */
    interface Presenter extends BasePresenter<View> {
    }
}
