package com.mvpSample.ui.home;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mvpSample.R;
import com.mvpSample.base.view.BaseActivity;
import com.mvpSample.data.db.BaseCommonData;
import com.mvpSample.data.entity.search.GetSearch;
import com.mvpSample.ui.searchResults.SearchResultActivity;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Home Activity
 */
public class HomeActivity extends BaseActivity implements HomeView, RecentSearchResultsAdapter.RecentSearchAdapterCallback {
    private HomePresenter presenter;
    private EditText etSearch;

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        super.initView();
        presenter = new HomePresenterImpl(getDeviceName(), this);
        presenter.onAttach(this);

        ((TextView) findViewById(R.id.tvTitle)).setText(getString(R.string.text_superheroes_and_villains));

        etSearch = findViewById(R.id.etSearch);
        etSearch.setOnEditorActionListener((v, actionId, event) -> {
            if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                presenter.fetchSuperherosOnSearch(etSearch.getText().toString());
            }
            return false;
        });
        setRecentSearchListInView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setRecentSearchListInView();
    }

    private void setRecentSearchListInView() {
        RecyclerView rvRecentSearchList = findViewById(R.id.rvRecentSearchList);
        rvRecentSearchList.setLayoutManager(new LinearLayoutManager(this));
        if (BaseCommonData.getRecentSearchList() != null && !BaseCommonData.getRecentSearchList().isEmpty()) {
            findViewById(R.id.tvRecentSearches).setVisibility(View.VISIBLE);
            RecentSearchResultsAdapter adapter = new RecentSearchResultsAdapter(BaseCommonData.getRecentSearchList(), this);
            rvRecentSearchList.setAdapter(adapter);
        } else {
            findViewById(R.id.tvRecentSearches).setVisibility(View.GONE);
        }
    }

    @Override
    public void onGetSearchResult(GetSearch getSearch) {
        saveSearchStringInRecentSearchList();
        if (getSearch != null) {
            if (getSearch.getSearchResults() != null && !getSearch.getSearchResults().isEmpty()) {
                startActivity(SearchResultActivity.createIntent(this, getSearch.getSearchResults()));
            }
        }
    }

    private void saveSearchStringInRecentSearchList() {
        ArrayList<String> recentSearchList;
        if (BaseCommonData.getRecentSearchList() != null && !BaseCommonData.getRecentSearchList().isEmpty()) {
            recentSearchList = BaseCommonData.getRecentSearchList();
        } else {
            recentSearchList = new ArrayList<>();
        }
        if (etSearch.getText().length() > 0) {
            recentSearchList.add(etSearch.getText().toString().trim());
            HashSet<String> hashSet = new HashSet<>(recentSearchList);
            recentSearchList.clear();
            recentSearchList.addAll(hashSet);
            BaseCommonData.saveRecentSearchList(recentSearchList);
            etSearch.setText("");
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onClickRecentSearchString(final String searchString) {
        presenter.fetchSuperherosOnSearch(searchString);
    }
}