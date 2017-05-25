package com.example.ths.demosearchuserdagger2;

import android.content.Context;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.NetworkModule;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.service.GitHubApi;
import com.example.ths.demosearchuserdagger2.utils.dagger.AppScope;
import com.example.ths.demosearchuserdagger2.utils.rx.BaseSchedulerProvider;
import dagger.Component;

/**
 * Created by ths on 23/05/2017.
 */
@AppScope
@Component(modules = { ApplicationModule.class, NetworkModule.class})
public interface AppComponent  {
    Context applicationContext();

    GitHubApi gitHubApi();

    BaseSchedulerProvider baseSchedulerProvider();
}
