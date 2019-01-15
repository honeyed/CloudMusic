package com.t.cloudmusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    private FragmentManager mfragmentManager;
    private List<Fragment> mlist;
    private List<String> list_title;

    public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list,List<String> title) {
        super(fm);
        this.mlist = list;
        this.list_title = title;
    }

    @Override
    public Fragment getItem(int arg0) {
        return mlist.get(arg0);//显示第几个页面
    }

    @Override
    public int getCount() {
        return mlist.size();//有几个页面
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position);
    }



}