package com.mvpSample.base.interactor;


import com.mvpSample.data.db.BaseCommonData;

/**
 * Base Interactor Impl
 */
public class BaseInteractorImpl implements BaseInteractor {

    @Override
    public void clearSessionManager() {
        BaseCommonData.clearData();
    }

}
