package com.t.cloudmusic.hook;

import com.t.cloudmusic.ui.main.MainActivity;

import java.util.Arrays;

// 检查是否需要登录 的activity
public class NeedLoginActivity {

    private String[] activities = {MainActivity.class.getName()};

    public boolean isNeedLogin(String activityName) {
//        for (String name : activities) {
//            if (name.equals(activityName)) {
//                return true;
//            }
//        }
        if(Arrays.asList(activities).contains(activityName)) {
            return true;
        }
        return false;
    }
}
