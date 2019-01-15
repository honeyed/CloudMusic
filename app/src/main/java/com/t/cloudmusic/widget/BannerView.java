package com.t.cloudmusic.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.t.cloudmusic.R;
import com.t.cloudmusic.adapter.BannerPagerAdapter;
import com.t.cloudmusic.common.WeakHandler;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BannerView extends FrameLayout implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
//    private List<String> urlList;
    private BannerDate bannerDate;
    private LinearLayout indicatorInside;
    private BannerPagerAdapter bannerPagerAdapter;
    private List<ImageView> imageViews;
    private List<ImageView> indicatorImages;
    private int lastPosition = 0;
    private int count = 1;
    private int mIndicatorSelectedResId = R.mipmap.cm2_play_playbar_curr_new;
    private int mIndicatorUnselectedResId = R.mipmap.cm2_play_playbar_ready;
    private int currentItem;
    private int delayTime = 2000;
    private WeakHandler handler = new WeakHandler();

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    public BannerView(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    public void initView(Context context,  AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.widget_banner, this, true);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setPageMargin(60);
        indicatorInside = view.findViewById(R.id.indicatorInside);
    }

    public List<String> getUrlList() {
        return bannerDate.getImageList();
    }

    public void setUrlList(BannerDate bannerDate) {
        this.bannerDate = bannerDate;
//        this.urlList = urlList;
        imageViews = new ArrayList<>();
        count = bannerDate.getImageList().size();
        indicatorImages = new ArrayList<>();
        for(int i = 0; i < bannerDate.getImageList().size(); i++) {
            ImageView imageView = new AppCompatImageView(this.getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageView linearImageView = new AppCompatImageView(this.getContext());
            if (i != 0)
                linearImageView.setImageResource(mIndicatorUnselectedResId);
            else
                linearImageView.setImageResource(mIndicatorSelectedResId);
            indicatorImages .add(linearImageView);
            indicatorInside.addView(linearImageView);
            imageViews.add(imageView);
        }
        bannerPagerAdapter = new BannerPagerAdapter(imageViews, bannerDate.getImageList());
        viewPager.setAdapter(bannerPagerAdapter);

        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
            int action = ev.getAction();
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL
                    || action == MotionEvent.ACTION_OUTSIDE) {
                start();
            } else if (action == MotionEvent.ACTION_DOWN) {
                stop();
        }
        return super.dispatchTouchEvent(ev);
    }

    public String[] getUrlArray() {
        return (String[]) bannerDate.getImageList().toArray();
    }

//    public void setUrlList(String[] urlList) {
//        setUrlList(Arrays.asList(bannerDate.getImageList()));
//    }

    public void start() {
        handler.postDelayed(task,delayTime);
    }

    public void stop() {
        handler.removeCallbacks(task);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        currentItem = position;
        indicatorImages.get(position == 0 ? count - 1 : position - 1).setImageResource(mIndicatorUnselectedResId);
        indicatorImages.get(position == (count - 1) ? 0 : position + 1).setImageResource(mIndicatorUnselectedResId);
        indicatorImages.get(position).setImageResource(mIndicatorSelectedResId);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    private final Runnable task = new Runnable() {
        @Override
        public void run() {
            if (count > 1) {
                currentItem++;
                if (currentItem == count)
                    currentItem =0;
                viewPager.setCurrentItem(currentItem);
                handler.postDelayed(task, delayTime);
            }
        }
    };

    public interface BannerDate {
        List<String> getImageList();
    }
}
