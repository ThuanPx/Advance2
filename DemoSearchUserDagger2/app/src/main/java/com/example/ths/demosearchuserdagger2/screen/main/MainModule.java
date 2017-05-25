package com.example.ths.demosearchuserdagger2.screen.main;

import android.app.Activity;
import com.example.ths.demosearchuserdagger2.data.source.UserRepository;
import com.example.ths.demosearchuserdagger2.data.source.UserRepositoryImpl;
import com.example.ths.demosearchuserdagger2.data.source.remote.UserRemoteDataSource;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.service.GitHubApi;
import com.example.ths.demosearchuserdagger2.utils.dagger.ActivityScope;
import com.example.ths.demosearchuserdagger2.utils.navigator.Navigator;
import com.example.ths.demosearchuserdagger2.utils.rx.BaseSchedulerProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ths on 23/05/2017.
 */
@Module
public class MainModule {
    private MainContract.View mMainView;

    public MainModule(MainContract.View mainView) {
        mMainView = mainView;
    }
    @ActivityScope
    @Provides
    public MainContract.Presenter providePresenter(UserRepository userRepository, BaseSchedulerProvider provider) {
        MainPresenter mainPresenter = new MainPresenter(mMainView, userRepository);
        mainPresenter.setSchedulerProvider(provider);
        return mainPresenter;
    }

    @ActivityScope
    @Provides
    public UserRepository provideUserRepository(GitHubApi gitHubApi) {
        return new UserRepositoryImpl(new UserRemoteDataSource(gitHubApi));
    }

    @ActivityScope
    @Provides
    public Navigator provideNavigator() {
        return new Navigator((Activity) mMainView);
    }
}
