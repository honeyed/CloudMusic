package com.t.cloudmusic.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.t.cloudmusic.R;
import com.t.cloudmusic.adapter.VipPagerAdapter;
import com.t.cloudmusic.data.main.RecommendBean;
import com.t.cloudmusic.widget.viewPagerTrans.TransFormer;

import java.util.ArrayList;
import java.util.List;

public class MemberView extends LinearLayout {

    private ViewPager viewPager;

    public MemberView(Context context) {
        super(context);
        init(context);
    }

    public MemberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MemberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MemberView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_vip, this, true);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.dp_4));
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageTransformer(false, new TransFormer());

    }

    public void setData(RecommendBean.Member member) {
        List<ImageView> imageViews = new ArrayList();
        for (int i = 0; i < member.getImageUrl().size(); i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
        }
        VipPagerAdapter vipPagerAdapter = new VipPagerAdapter(imageViews, member.getImageUrl());
        viewPager.setAdapter(vipPagerAdapter);
        viewPager.setCurrentItem(1);
    }
}
