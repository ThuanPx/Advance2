package com.example.ths.demosearchuserrx.screen.searhresult;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.ths.demosearchuserrx.R;
import com.example.ths.demosearchuserrx.data.model.ListUser;
import com.example.ths.demosearchuserrx.databinding.ActivitySearchResultBinding;
import com.example.ths.demosearchuserrx.utils.Constant;

public class SearchResultActivity extends AppCompatActivity {
    private SearchResultViewModel mSearchResultViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchResultBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_search_result);
        SearchResultAdapter mSearchResultAdapter = new SearchResultAdapter(this);
        ListUser mListUser = getIntent().getParcelableExtra(Constant.KEY_BUNDLE);

        mSearchResultViewModel = new SearchResultViewModel(mSearchResultAdapter,mListUser);
        binding.setViewModel(mSearchResultViewModel);

    }
}
