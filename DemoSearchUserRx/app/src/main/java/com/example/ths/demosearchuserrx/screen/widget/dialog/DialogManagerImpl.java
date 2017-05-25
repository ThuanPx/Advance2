package com.example.ths.demosearchuserrx.screen.widget.dialog;

import android.content.Context;
import com.fstyle.library.MaterialDialog;

/**
 * Created by ths on 19/05/2017.
 */

public class DialogManagerImpl implements DialogManager {
    private Context mContext;
    private MaterialDialog mProgressDialog;

    public DialogManagerImpl(Context context) {
        mContext = context;
    }

    @Override
    public void showProgress() {
        if(mProgressDialog==null){
            mProgressDialog = new MaterialDialog.Builder(mContext).content("Please wait…")
                    .progress(true, 0)
                    .canceledOnTouchOutside(false)
                    .build();
        }
        mProgressDialog.show();
    }

    @Override
    public void hideDProgress() {
        if(mProgressDialog==null)return;
        mProgressDialog.dismiss();
    }
}
