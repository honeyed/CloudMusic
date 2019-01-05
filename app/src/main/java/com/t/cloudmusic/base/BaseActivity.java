package com.t.cloudmusic.base;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView<T> {

    @Override
    public void showErrorMsg(String message) {

    }

    @Override
    public void showLoadingDialog(String msg) {

    }


}
