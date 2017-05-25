package com.example.ths.demologinmvvm.utils.navigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by ths on 17/05/2017.
 */

public class Navigator {
    private Activity mActivity;

    public Activity getActivity() {
        return mActivity;
    }

    public Navigator(Activity activity) {
        mActivity = activity;
    }
    public void Toast( String test){
        Toast.makeText(mActivity,test,Toast.LENGTH_SHORT).show();
    }
    public void startActivity(Class <? extends Activity> clazz,Bundle bundle){
        Intent intent = new Intent(mActivity,clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startActivity(Intent intent) {
        mActivity.startActivity(intent);

    }
}
