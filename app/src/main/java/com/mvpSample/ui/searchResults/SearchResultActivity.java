package com.mvpSample.ui.searchResults;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mvpSample.R;
import com.mvpSample.base.view.BaseActivity;
import com.mvpSample.data.entity.search.SearchResult;
import com.mvpSample.ui.characterDetails.CharacterDetailsActivity;

import java.util.ArrayList;

/**
 * Search Result Activity
 */
public class SearchResultActivity extends BaseActivity implements SearchResultsAdapter.SearchResultAdapterCallback {
    private static final String EXTRA_SEARCH_LIST = "EXTRA_SEARCH_LIST";
    private ArrayList<SearchResult> searchResultArrayList;

    /**
     * Create intent.
     *
     * @param mContext the m context
     * @return the intent
     */
    public static Intent createIntent(final Context mContext, final ArrayList<SearchResult> searchResulstList) {
        Intent intent = new Intent(mContext, SearchResultActivity.class);
        intent.putParcelableArrayListExtra(EXTRA_SEARCH_LIST, searchResulstList);
        return intent;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_search_result;
    }

    @Override
    protected void initView() {
        super.initView();
        if (getIntent() != null && getIntent().hasExtra(EXTRA_SEARCH_LIST)) {
            searchResultArrayList = getIntent().getParcelableArrayListExtra(EXTRA_SEARCH_LIST);
        }
        findViewById(R.id.ivBack).setVisibility(View.VISIBLE);
        findViewById(R.id.ivBack).setOnClickListener(view -> onBackPressed());

        ((TextView) findViewById(R.id.tvTitle)).setText(R.string.text_search_results);
        setRecyclerView();
    }

    private void setRecyclerView() {
        RecyclerView rvSearchResultList = findViewById(R.id.rvSearchResultList);
        rvSearchResultList.setLayoutManager(new LinearLayoutManager(this));
        if (searchResultArrayList != null && !searchResultArrayList.isEmpty()) {
            SearchResultsAdapter adapter = new SearchResultsAdapter(searchResultArrayList, this);
            rvSearchResultList.setAdapter(adapter);
        }
    }

    @Override
    public void openDetailsForSearchItem(final SearchResult searchResult) {
        startActivity(CharacterDetailsActivity.createIntent(this, searchResult));
    }
}