package com.example.ths.demosearchuserrx.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by ths on 21/05/2017.
 */

public interface BaseSchedulerProvider {
    Scheduler io();
    Scheduler ui();
}
