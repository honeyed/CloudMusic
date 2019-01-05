package com.t.cloudmusic.ui.login;

import com.t.cloudmusic.base.BaseView;

import java.lang.ref.WeakReference;

public class LoginPresenter implements LoginContract.Presenter {

    private WeakReference baseView;

    public LoginPresenter(BaseView baseView1) {
        baseView = new WeakReference<BaseView>(baseView1);
    }

    public void doLogin(String username, String password) {

    }

    @Override
    public void start() {

    }
}
