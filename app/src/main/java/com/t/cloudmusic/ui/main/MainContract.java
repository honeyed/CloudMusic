package com.t.cloudmusic.ui.main;

import com.t.cloudmusic.base.IPresenter;
import com.t.cloudmusic.base.IView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface MainContract {

    interface View extends IView<Presenter> {

        void setProgressIndicator(boolean active);

        void showStatistics(int numberOfIncompleteTasks, int numberOfCompletedTasks);

        void showLoadingStatisticsError();

        boolean isActive();
    }

    interface DiscoverView extends IView<Presenter> {
        
    }

    interface Presenter extends IPresenter {

    }
}