package com.t.cloudmusic.ui.login;

import com.t.cloudmusic.base.IPresenter;
import com.t.cloudmusic.base.IView;

public interface LoginContract {

    interface LoginPresenter extends IPresenter {
        void doLogin(String name,String pass);
    }

    interface LoginView extends IView<LoginPresenter> {

        void loginSuccess();

        void loginFailed(int state, String message);
    }

    interface RegisterView extends IView<LoginContract.LoginPresenter> {
        void doLogin(String userName, String passWord);
    }

    interface GetVerificationCode extends IView<LoginContract.LoginPresenter> {
        void success(String verificationCode);
    }
}
