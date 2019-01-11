package com.t.cloudmusic.ui.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BActivity;
import com.t.cloudmusic.base.IBackHandledInterface;

public class MainActivity extends BActivity<MainContract.Presenter> implements MainContract.View,IBackHandledInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void showStatistics(int numberOfIncompleteTasks, int numberOfCompletedTasks) {

    }

    @Override
    public void showLoadingStatisticsError() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public MainContract.Presenter newP() {
        return new MainPresenter();
    }

    @Override
    public void setSelectedFragment(Fragment fragment) {

    }
}
