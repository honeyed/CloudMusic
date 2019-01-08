package com.t.cloudmusic.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BaseActivity;
import com.t.cloudmusic.base.BasePresenter;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements View.OnClickListener {

    private LoginContract.Presenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.setStatusBarColor(Color.TRANSPARENT);
                //设置字体黑色
                View decor = window.getDecorView();
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

//                Window window = this.getWindow();
////                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
////                window.setStatusBarColor(Color.WHITE);
                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        setPresenter(presenter);

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginByMobil:
                startActivity(new Intent(LoginActivity.this, LoginByMobilActivity.class));
                break;
            case R.id.register:
                break;
            case R.id.visitor:
                break;

        }
    }
}
