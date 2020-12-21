package com.mvpSample.data.db;


import java.util.ArrayList;

/**
 * BaseCommonData
 */
public class BaseCommonData {
    private static BaseDbHelperImpl mBaseDbHelper;

    /**
     * Empty Constructor
     * not called
     */
    private BaseCommonData() {
    }

    /**
     * Gets db.
     *
     * @return the db
     */
    private static BaseDbHelperImpl getDb() {
        if (mBaseDbHelper == null) {
            mBaseDbHelper = new BaseDbHelperImpl();
        }
        return mBaseDbHelper;
    }

    /**
     * Gets show hide dialog
     *
     * @return the boolean
     */
    public static boolean getDialogVisibility() {
        return getDb().getDialogVisibility();
    }

    /**
     * set show hide dialog
     *
     * @param isVisible the isVisible
     */
    public static void setDialogVisibility(final boolean isVisible) {
        getDb().setDialogVisibility(isVisible);
    }


    /**
     * Save access token.
     *
     * @param accessToken the access token
     */
    public static void saveAccessToken(final String accessToken) {
        getDb().saveAccessToken(accessToken);
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public static String getAccessToken() {
        return getDb().getAccessToken();
    }

    /**
     * Save recent searchList
     *
     * @param searchList the searchList
     */
    public static void saveRecentSearchList(final ArrayList<String> searchList) {
        getDb().saveRecentSearchList(searchList);
    }

    /**
     * Gets recent search List
     *
     * @return the recent searchList
     */
    public static ArrayList<String> getRecentSearchList() {
        return getDb().getRecentSearchList();
    }

    /**
     * Clear data.
     */
    public static void clearData() {
        getDb().clearDb();
    }

}
