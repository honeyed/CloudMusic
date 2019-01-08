package com.t.cloudmusic.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.bumptech.glide.request.transition.Transition;
import com.t.cloudmusic.R;
import com.t.cloudmusic.adapter.SplashAdapter;
import com.t.cloudmusic.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private ViewPager splashViewPager;
    private SplashAdapter splashAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        window.setStatusBarColor(Color.TRANSPARENT);
        //设置字体黑色
//        View decor = window.getDecorView();
//        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_splash);
        splashViewPager = findViewById(R.id.splashViewPager);
        splashAdapter = new SplashAdapter(this);
        splashViewPager.setAdapter(splashAdapter);
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}
