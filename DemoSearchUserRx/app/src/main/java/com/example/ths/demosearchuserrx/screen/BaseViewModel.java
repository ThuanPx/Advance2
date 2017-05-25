package com.example.ths.demosearchuserrx.screen;

import android.databinding.BaseObservable;
import com.example.ths.demosearchuserrx.utils.rx.BaseSchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscription;

/**
 * Created by ths on 19/05/2017.
 */

public abstract class BaseViewModel extends BaseObservable{
    private final CompositeDisposable mCompositeDisposable;

    public BaseViewModel() {
        mCompositeDisposable = new CompositeDisposable();
    }
    public void onStop(){
        mCompositeDisposable.clear();
    }
    public void startSubscriber(Disposable disposable){
        mCompositeDisposable.add(disposable);

    }
    public abstract void setSchedulerProvider(BaseSchedulerProvider schedulerProvider);
}
