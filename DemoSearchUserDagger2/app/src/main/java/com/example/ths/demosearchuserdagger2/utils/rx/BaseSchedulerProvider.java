package com.example.ths.demosearchuserdagger2.utils.rx;

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;

/**
 * Created by ths on 23/05/2017.
 */

public interface BaseSchedulerProvider {
    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
