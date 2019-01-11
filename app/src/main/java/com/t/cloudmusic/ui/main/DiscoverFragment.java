package com.t.cloudmusic.ui.main;

import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.t.cloudmusic.R;
import com.t.cloudmusic.adapter.TabFragmentPagerAdapter;
import com.t.cloudmusic.base.BFragment;
import com.t.cloudmusic.ui.main.discovert.RecommendFragment;
import com.t.cloudmusic.widget.tabLayout.XTabLayout;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends BFragment {

    private ViewPager viewPager;
    private XTabLayout mTabLayout;
    private TabFragmentPagerAdapter adapter;
    private ImageView isPlaying;
    private AnimationDrawable anim;
    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_discover;
    }

    @Override
    protected void bindView() {
        isPlaying = (ImageView) findViewById(R.id.isPlaying);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (XTabLayout) findViewById(R.id.tabLayout);
        List<String> titles = new ArrayList<>();
        titles.add("个性推荐");
        titles.add("主播电台");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new RecommendFragment());
        mTabLayout.setupWithViewPager(viewPager);
        adapter = new TabFragmentPagerAdapter(getFragmentManager(), fragmentList, titles);
        viewPager.setAdapter(adapter);
        anim = (AnimationDrawable) isPlaying.getDrawable();


    }

    @Override
    public void onResume() {
        super.onResume();
        anim.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        anim.stop();
    }

    @Override
    public void showErrorMsg(String message) {

    }

    @Override
    public Object newP() {
        return null;
    }
}
