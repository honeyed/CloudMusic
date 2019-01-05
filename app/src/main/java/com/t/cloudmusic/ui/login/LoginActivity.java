package com.t.cloudmusic.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.t.cloudmusic.base.BaseActivity;
import com.t.cloudmusic.base.BasePresenter;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> {

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter();
        setPresenter(presenter);

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }
}
