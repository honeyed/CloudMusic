package com.t.cloudmusic;

import android.app.Application;

import com.t.cloudmusic.hook.HookLoginUtil;

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //提出是hook技术，检查activity是否需要登录的
        HookLoginUtil hookUtil = new HookLoginUtil(this);
        hookUtil.hookActivityStart();
        hookUtil.hookHandlerCallBack();
    }

    public static App getInstance() {
        return instance;
    }
}
