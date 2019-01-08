package com.t.cloudmusic.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BaseActivity;

public class LoginByMobilActivity extends BaseActivity<LoginPresenter> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_by_mobile);
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {

    }
}
