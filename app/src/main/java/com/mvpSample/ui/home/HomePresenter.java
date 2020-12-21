package com.mvpSample.ui.home;


import com.mvpSample.base.presenter.BasePresenter;

/**
 * Home Presenter
 */
public interface HomePresenter extends BasePresenter {

    /**
     * fetchSuperherosOnSearch
     */
    void fetchSuperherosOnSearch(String name);
}
