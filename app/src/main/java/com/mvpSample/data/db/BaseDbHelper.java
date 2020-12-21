package com.mvpSample.data.db;

import java.util.ArrayList;

/**
 * BaseDbHelper
 */
public interface BaseDbHelper {

    /**
     * Gets access token.
     *
     * @return the access token
     */
    String getAccessToken();

    /**
     * Save access token.
     *
     * @param accessToken the access token
     */
    void saveAccessToken(String accessToken);

    /**
     * Clear session manager.
     */
    void clearSessionManager();

    /**
     * getDialogVisibility
     *
     * @return the Visibility
     */
    boolean getDialogVisibility();

    /**
     * setDialogVisibility
     *
     * @param isVisible the isVisible
     */
    void setDialogVisibility(boolean isVisible);

    /**
     * save Recent search list
     *
     * @param searchList search list
     */
    void saveRecentSearchList(ArrayList<String> searchList);

    /**
     * get recent search list
     *
     * @return recent list
     */
    ArrayList<String> getRecentSearchList();
}
