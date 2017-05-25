package com.example.ths.demosearchuserdagger2.utils.rx;

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ths on 23/05/2017.
 */

public class SchedulerProvider implements BaseSchedulerProvider {
    private static SchedulerProvider mInstance;
    public SchedulerProvider() {
    }
    public static synchronized SchedulerProvider getInstance() {
        if (mInstance == null) {
            mInstance = new SchedulerProvider();
        }
        return mInstance;
    }
    @NonNull
    @Override
    public Scheduler io() {
          return Schedulers.io();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
