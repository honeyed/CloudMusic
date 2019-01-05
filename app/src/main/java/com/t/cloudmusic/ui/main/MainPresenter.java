package com.t.cloudmusic.ui.main;

import android.support.annotation.NonNull;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Listens to user actions from the UI ({@link }), retrieves the data and updates
 * the UI as required.
 */
public class MainPresenter implements MainContract.Presenter {


    @Override
    public void start() {
        loadStatistics();
    }

    private void loadStatistics() {

    }
}