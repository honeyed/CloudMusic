package com.t.cloudmusic.ui.main;

import com.t.cloudmusic.base.BasePresenter;
import com.t.cloudmusic.base.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {

        void setProgressIndicator(boolean active);

        void showStatistics(int numberOfIncompleteTasks, int numberOfCompletedTasks);

        void showLoadingStatisticsError();

        boolean isActive();
    }

    interface Presenter extends BasePresenter {

    }
}