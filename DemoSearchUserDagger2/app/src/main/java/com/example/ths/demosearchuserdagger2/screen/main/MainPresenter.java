package com.example.ths.demosearchuserdagger2.screen.main;

import android.util.Log;
import com.example.ths.demosearchuserdagger2.data.model.User;
import com.example.ths.demosearchuserdagger2.data.source.UserRepository;
import com.example.ths.demosearchuserdagger2.data.source.UserRepositoryImpl;
import com.example.ths.demosearchuserdagger2.utils.navigator.Navigator;
import com.example.ths.demosearchuserdagger2.utils.rx.BaseSchedulerProvider;
import com.example.ths.demosearchuserdagger2.utils.rx.SchedulerProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import org.reactivestreams.Subscription;

/**
 * Created by ths on 23/05/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mMainView;
    private UserRepository mUserRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainContract.View mainView, UserRepository userRepository) {
        mMainView = mainView;
        mUserRepository = userRepository;
        mCompositeDisposable =new CompositeDisposable();
    }

    @Override
    public void setSchedulerProvider(BaseSchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void searchUsers(int limit, String keyWord) {
        Disposable disposable =mUserRepository.searchUsers(limit,keyWord)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribeWith(new DisposableObserver<List<User>>() {
                    @Override
                    public void onNext(@NonNull List<User> users) {
                      mMainView.onSearchSuccess(users);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                            mMainView.onSearchError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}
