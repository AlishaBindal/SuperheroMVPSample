package com.mvpSample.base;

import com.mvpSample.data.db.BaseDbHelper;
import com.mvpSample.data.db.BaseDbHelperImpl;

import java.util.ArrayList;

/**
 * Base Data Manager Impl
 **/
public class BaseDataManagerImpl implements BaseDataManager {
    private final BaseDbHelper mBaseDbHelper;

    /**
     * Instantiates a new Data manager.
     */
    public BaseDataManagerImpl() {
        this.mBaseDbHelper = new BaseDbHelperImpl();
    }

    @Override
    public String getAccessToken() {
        return mBaseDbHelper.getAccessToken();
    }

    @Override
    public void saveAccessToken(final String accessToken) {
        mBaseDbHelper.saveAccessToken(accessToken);
    }

    @Override
    public void clearSessionManager() {
        mBaseDbHelper.clearSessionManager();
    }

    @Override
    public boolean getDialogVisibility() {
        return mBaseDbHelper.getDialogVisibility();
    }

    @Override
    public void setDialogVisibility(boolean isVisible) {
        mBaseDbHelper.setDialogVisibility(isVisible);
    }

    @Override
    public void saveRecentSearchList(final ArrayList<String> searchList) {
        mBaseDbHelper.saveRecentSearchList(searchList);
    }

    @Override
    public ArrayList<String> getRecentSearchList() {
        return mBaseDbHelper.getRecentSearchList();
    }

}
