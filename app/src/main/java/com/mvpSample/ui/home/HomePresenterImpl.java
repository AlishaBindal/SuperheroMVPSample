package com.mvpSample.ui.home;

import android.util.Log;

import androidx.annotation.NonNull;

import com.mvpSample.base.presenter.BasePresenterImpl;
import com.mvpSample.data.entity.search.GetSearch;
import com.mvpSample.data.network.ApiError;

import static com.mvpSample.data.network.AppConstant.SESSION_EXPIRED;

/**
 * Home Presenter Impl
 */
public class HomePresenterImpl extends BasePresenterImpl implements HomePresenter {

    private final HomeView mHomeView;
    private final HomeInteractor mHomeInteractor;

    HomePresenterImpl(final String deviceName, @NonNull HomeView homeView) {
        super(deviceName);
        mHomeView = homeView;
        mHomeInteractor = new HomeInteractorImpl();
    }

    @Override
    public void fetchSuperherosOnSearch(String name) {
        if (isViewAttached()) {
            mHomeView.showLoading();
        }
        mHomeInteractor.searchSuperHero(name, new HomeInteractor.SearchSuperheroListener() {
            @Override
            public void onSuccess(GetSearch getSearch) {
                if (isViewAttached()) {
                    mHomeView.hideLoading();
                    mHomeView.onGetSearchResult(getSearch);
                }
            }

            @Override
            public void onFailure(ApiError apiError, Throwable throwable) {
                if (isViewAttached()) {
                    mHomeView.hideLoading();
                    if (apiError != null) {
                        mHomeView.showErrorMessage(apiError.getMessage(), () -> {
                            if (apiError.getStatusCode() == SESSION_EXPIRED) {
                                mHomeView.restartApp();
                            }
                        });
                    } else if (throwable != null) {
                        mHomeView.showErrorMessage(throwable.getMessage());
                        if (throwable.getCause() != null)
                            Log.v("error", throwable.getCause().getMessage() + " " + throwable.getCause().getLocalizedMessage());
                    }
                }
            }
        });
    }
}
