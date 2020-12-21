package com.mvpSample.base.presenter;
import com.mvpSample.base.view.BaseView;

/**
 * Base Presenter
 */
public interface BasePresenter {

    /**
     * On attach.
     *
     * @param view the view
     */
    void onAttach(BaseView view);

    /**
     * On detach.
     */
    void onDetach();

    /**
     * Delete local db.
     */
    void deleteLocalDb();
}
