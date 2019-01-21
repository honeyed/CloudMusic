package com.t.cloudmusic.ui.main;

import com.t.cloudmusic.base.IPresenter;
import com.t.cloudmusic.base.IView;
import com.t.cloudmusic.data.AdapterBean;
import com.t.cloudmusic.data.main.MusicBean;
import com.t.cloudmusic.data.main.RecommendBean;

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

        void onDataSuccess(AdapterBean recommendBean);
    }

    interface MusicView extends IView<Presenter> {
        void onDataSuccess(AdapterBean musicBean);
    }

    interface Presenter extends IPresenter {

        void getRecommendDate();

        void getMusicDate();
    }
}