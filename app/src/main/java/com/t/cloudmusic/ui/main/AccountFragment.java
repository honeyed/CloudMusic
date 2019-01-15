package com.t.cloudmusic.ui.main;

import com.t.cloudmusic.base.BFragment;

public class AccountFragment extends BFragment<MainContract.Presenter> {
    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void bindView() {

    }

    @Override
    public void showErrorMsg(String message) {

    }

    @Override
    public MainContract.Presenter newP() {
        return null;
    }
}
