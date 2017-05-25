package com.example.ths.demosearchuserrx.utils.navigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ths on 21/05/2017.
 */

public class Navigator {
    private Activity mActivity;

    public Navigator(Activity activity) {
        mActivity = activity;
    }
    private void startActivity(Intent intent){
        mActivity.startActivity(intent);
    }
    public void startActivity(Class<? extends Activity> clazz,Bundle bundle){
        Intent intent = new Intent(mActivity,clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
