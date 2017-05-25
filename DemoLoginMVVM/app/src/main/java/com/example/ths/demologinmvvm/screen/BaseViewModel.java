package com.example.ths.demologinmvvm.screen;

import android.databinding.BaseObservable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ths on 17/05/2017.
 */

public abstract class BaseViewModel extends BaseObservable {
    public void LoginError(){
        Log.d("Login ","Error");
    }
    public void LoginCancel(){
        Log.d("Login ","Cancel");
    }
}
