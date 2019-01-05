package com.t.cloudmusic.ui.login;

import com.t.cloudmusic.base.BasePresenter;
import com.t.cloudmusic.base.BaseView;
import com.t.cloudmusic.ui.main.MainContract;

public interface LoginContract {

    interface Presenter extends BasePresenter {

    }

    interface LoginView extends BaseView<MainContract.Presenter> {

        void loginSuccess();

        void loginFailed(int state, String message);
    }

    interface RegisterView extends BaseView<MainContract.Presenter> {

    }

    interface GetVerificationCode extends BaseView<MainContract.Presenter> {
        void success(String verificationCode);
    }
}
