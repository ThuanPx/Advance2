package com.example.ths.demosearchuserdagger2.utils.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ths on 23/05/2017.
 */

public class Navigator {
    private Activity mActivity;

    public Navigator(Activity activity) {
        mActivity = activity;
    }

    public Activity getActivity() {
        return mActivity;
    }
    private void startActivity(Intent intent){
        mActivity.startActivity(intent);
    }
    public void startActivity(Class <? extends Activity> clazz,Bundle bundle){
        Intent intent = new Intent(mActivity,clazz);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
