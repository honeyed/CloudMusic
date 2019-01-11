package com.t.cloudmusic.ui.login;

import com.t.cloudmusic.base.BPresenter;

public class LoginPresenter extends BPresenter implements LoginContract.LoginPresenter {

    @Override
    public void doLogin(String username, String password) {
        ((LoginContract.LoginView) getV()).loginSuccess();
    }

}
