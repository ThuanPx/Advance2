package com.example.ths.demosearchuserdagger2.screen.searchresult;

/**
 * Created by ths on 23/05/2017.
 */

public class SearchResultPresenter implements SearchResultContract.Presenter {
    private SearchResultContract.View mView ;

    public SearchResultPresenter(SearchResultContract.View view) {
        mView = view;
    }

}
