package com.t.cloudmusic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BActivity;
import com.t.cloudmusic.common.SPUtils;
import com.t.cloudmusic.common.SP_Constant;
import com.t.cloudmusic.ui.main.MainActivity;

public class StartActivity  extends BActivity {

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SPUtils.getInstance().putBoolean(SP_Constant.IS_LOGIN, false);
        //无title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
//        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
//                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                boolean first = SPUtils.getInstance().getBoolean("first", true);
                if(first) {
                    Intent intent = new Intent(StartActivity.this,SplashActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(StartActivity.this,MainActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        };
        countDownTimer.start();
    }

    @Override
    public Object newP() {
        return null;
    }
}
