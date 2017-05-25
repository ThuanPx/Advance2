package com.example.ths.demosearchuserdagger2;

import android.app.Application;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.NetworkModule;

/**
 * Created by ths on 23/05/2017.
 */

public class MainApplication extends Application {
    private AppComponent mAppComponent;
    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .applicationModule(new ApplicationModule(getApplicationContext()))
                    .networkModule(new NetworkModule(this))
                    .build();
        }
        return mAppComponent;
    }
}
