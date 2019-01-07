package com.t.cloudmusic.ui.login;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BaseActivity;
import com.t.cloudmusic.base.BasePresenter;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> {

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.WHITE);
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
}
