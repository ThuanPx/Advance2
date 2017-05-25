package com.example.ths.demosearchuserrx.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ths on 21/05/2017.
 */

public class SchedulerProvider implements BaseSchedulerProvider {
    private static SchedulerProvider mSchedulerProvider;

    public SchedulerProvider() {
    }
    public static synchronized SchedulerProvider getInstance(){
        if(mSchedulerProvider==null){
            mSchedulerProvider = new SchedulerProvider();
        }
        return mSchedulerProvider;
    }
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
