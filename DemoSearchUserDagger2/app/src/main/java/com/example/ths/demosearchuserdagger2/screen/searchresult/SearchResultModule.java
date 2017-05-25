package com.example.ths.demosearchuserdagger2.screen.searchresult;

import android.app.Activity;
import com.example.ths.demosearchuserdagger2.data.model.User;
import com.example.ths.demosearchuserdagger2.utils.Constant;
import com.example.ths.demosearchuserdagger2.utils.dagger.ActivityScope;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;

/**
 * Created by ths on 23/05/2017.
 */
@Module
public class SearchResultModule {
    private SearchResultContract.View mView;
    public SearchResultModule(SearchResultContract.View view) {
        this.mView = view;
    }
    @ActivityScope
    @Provides
    public SearchResultContract.Presenter providePresenter() {
        return new SearchResultPresenter(mView);
    }
    @ActivityScope
    @Provides
    public SearchResultAdapter provideSearchResultAdapter() {
        Activity activity = (Activity) mView;
        ArrayList<User> users = activity.getIntent().getParcelableArrayListExtra(Constant
                .KEY_BUNDLE);
        return new SearchResultAdapter(activity,users);
    }
}
