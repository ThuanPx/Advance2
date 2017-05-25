package com.example.ths.demosearchuserdagger2.screen.searchresult;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ths.demosearchuserdagger2.MainApplication;
import com.example.ths.demosearchuserdagger2.R;
import com.example.ths.demosearchuserdagger2.data.model.User;
import com.example.ths.demosearchuserdagger2.utils.Constant;
import java.util.List;
import javax.inject.Inject;

public class SearchResultActivity extends Activity implements SearchResultContract.View {
    @Inject
    SearchResultAdapter mSearchResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DaggerSearchResultComponent.builder().appComponent(((MainApplication) getApplication())
                .getAppComponent()).searchResultModule(new SearchResultModule(this)).build()
                .inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mSearchResultAdapter);

    }
}
