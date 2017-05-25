package com.example.ths.demosearchuserdagger2;

import android.content.Context;
import com.example.ths.demosearchuserdagger2.utils.dagger.AppScope;
import com.example.ths.demosearchuserdagger2.utils.rx.BaseSchedulerProvider;
import com.example.ths.demosearchuserdagger2.utils.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ths on 23/05/2017.
 */
@Module
public class ApplicationModule {
    private Context mContext;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @AppScope
    public Context provideApplicationContext() {
        return mContext;
    }

    @Provides
    @AppScope
    public BaseSchedulerProvider provideBaseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
