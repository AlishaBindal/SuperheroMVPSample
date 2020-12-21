package com.mvpSample.ui.home;


import com.mvpSample.base.interactor.BaseInteractorImpl;
import com.mvpSample.data.entity.search.GetSearch;
import com.mvpSample.data.network.ApiError;
import com.mvpSample.data.network.ResponseResolver;
import com.mvpSample.data.network.RestClient;

/**
 * Home Interactor Impl
 */
public class HomeInteractorImpl extends BaseInteractorImpl implements HomeInteractor {

    @Override
    public void searchSuperHero(String name, SearchSuperheroListener mApiListener) {
        RestClient.getApiInterface().searchSuperhero(name).enqueue(new ResponseResolver<GetSearch>() {
            @Override
            public void onSuccess(GetSearch getSearch) {
                mApiListener.onSuccess(getSearch);
            }

            @Override
            public void onError(ApiError error) {
                mApiListener.onFailure(error, null);
            }

            @Override
            public void onFailure(Throwable throwable) {
                mApiListener.onFailure(null, throwable);
            }
        });
    }
}
