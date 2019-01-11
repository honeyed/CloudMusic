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
        // 目前的问题是，用hook登录办法，intent设置的flags就没效果了，目前原因没找到
//        HookLoginUtil hookUtil = new HookLoginUtil(this);
//        hookUtil.hookActivityStart();
//        hookUtil.hookHandlerCallBack();
    }

    public static App getInstance() {
        return instance;
    }
}
