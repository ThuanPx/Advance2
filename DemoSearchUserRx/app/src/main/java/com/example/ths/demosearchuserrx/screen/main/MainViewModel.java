package com.example.ths.demosearchuserrx.screen.main;

import android.databinding.Bindable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.ths.demosearchuserrx.BR;
import com.example.ths.demosearchuserrx.data.model.ListUser;
import com.example.ths.demosearchuserrx.data.source.remote.api.service.ClientService;
import com.example.ths.demosearchuserrx.data.source.remote.api.service.GitHubApi;
import com.example.ths.demosearchuserrx.screen.BaseViewModel;
import com.example.ths.demosearchuserrx.screen.searhresult.SearchResultActivity;
import com.example.ths.demosearchuserrx.screen.widget.dialog.DialogManager;
import com.example.ths.demosearchuserrx.utils.Constant;
import com.example.ths.demosearchuserrx.utils.commom.StringUtils;
import com.example.ths.demosearchuserrx.utils.navigator.Navigator;
import com.example.ths.demosearchuserrx.utils.rx.BaseSchedulerProvider;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.Subject;

/**
 * Created by ths on 19/05/2017.
 */

public class MainViewModel extends BaseViewModel {
    private String keyUser;
    private String limit;
    private DialogManager mDialogManager;
    private Navigator mNavigator;
    private BaseSchedulerProvider mSchedulerProvider;

    public MainViewModel(DialogManager dialogManager, Navigator navigator) {
        mDialogManager = dialogManager;
        mNavigator = navigator;
    }

    @Bindable
    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
        notifyPropertyChanged(BR.limit);
    }

    @Bindable
    public String getKeyUser() {
        return keyUser;
    }

    public void setKeyUser(String keyUser) {
        this.keyUser = keyUser;
        notifyPropertyChanged(BR.keyUser);
    }

    public void clickButtonSearch(View view) {
        searchUsers();
    }

    private void searchUsers() {
        GitHubApi service = ClientService.createService(GitHubApi.class);
        Disposable mDisposable = service.searchUserGitHub(keyUser, StringUtils.convertStringToNumber(limit))
                        .subscribeOn(mSchedulerProvider.io())
                        .observeOn(mSchedulerProvider.ui())
                        .subscribeWith(new DisposableObserver<ListUser>() {
                            @Override
                            public void onNext(@NonNull ListUser listUser) {
                                goToSearchResultActivity(listUser);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.d("Error",e.getLocalizedMessage());
                            }

                            @Override
                            public void onComplete() {
                            }
                        });

        startSubscriber(mDisposable);
    }



    private void goToSearchResultActivity(ListUser t) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.KEY_BUNDLE, t);
        mNavigator.startActivity(SearchResultActivity.class, bundle);
    }

    @Override
    public void setSchedulerProvider(BaseSchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }
}
