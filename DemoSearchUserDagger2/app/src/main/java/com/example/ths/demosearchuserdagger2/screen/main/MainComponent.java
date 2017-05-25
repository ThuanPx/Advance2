package com.example.ths.demosearchuserdagger2.screen.main;

import com.example.ths.demosearchuserdagger2.AppComponent;
import com.example.ths.demosearchuserdagger2.utils.dagger.ActivityScope;
import dagger.Component;

/**
 * Created by ths on 23/05/2017.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
