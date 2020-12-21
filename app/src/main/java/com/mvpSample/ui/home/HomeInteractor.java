package com.mvpSample.ui.home;

import com.mvpSample.base.interactor.BaseInteractor;
import com.mvpSample.data.entity.search.GetSearch;
import com.mvpSample.data.network.ApiError;

/**
 * Home Interactor
 */
public interface HomeInteractor extends BaseInteractor {

    /**
     * searchSuperHero
     *
     * @param name         name
     * @param mApiListener the m api listener
     */
    void searchSuperHero(String name, SearchSuperheroListener mApiListener);

    /**
     * The interface Api listener.
     */
    interface SearchSuperheroListener {
        /**
         * On success.
         *
         * @param getSearch getSearch
         */
        void onSuccess(GetSearch getSearch);

        /**
         * On failure.
         *
         * @param apiError  the api error
         * @param throwable the throwable
         */
        void onFailure(ApiError apiError, Throwable throwable);
    }
}
