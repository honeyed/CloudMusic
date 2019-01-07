package com.t.cloudmusic.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView<T> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,this.getClass().getSimpleName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMsg(String message) {

    }

    @Override
    public void showLoadingDialog(String msg) {

    }

}
