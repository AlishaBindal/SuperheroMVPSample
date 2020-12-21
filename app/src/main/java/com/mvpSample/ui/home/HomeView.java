package com.mvpSample.ui.home;

import com.mvpSample.base.view.BaseView;
import com.mvpSample.data.entity.search.GetSearch;

/**
 * Home View
 */
public interface HomeView extends BaseView {
    void onGetSearchResult(GetSearch getSearch);
}
