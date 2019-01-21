package com.t.cloudmusic.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.t.cloudmusic.data.imageLoader.ImageLoader;

import java.util.List;

public class VipPagerAdapter extends PagerAdapter {

    private List<ImageView> imageViews;
    private List<String> urlList;

    public VipPagerAdapter(List<ImageView> imageViews, List<String> urlList) {
        this.imageViews = imageViews;
        this.urlList = urlList;
    }

    @Override
    public int getCount() {
        return imageViews.size();
//        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
//        int realPosition = position % imageViews.size();
        ImageView view = imageViews.get(position);
        ImageLoader.loadRoundImage(view.getContext(), view, urlList.get(position));
//        ViewGroup viewGroup = (ViewGroup) imageViews.get(realPosition).getParent();
//        if(viewGroup != null)
//            viewGroup.removeView(imageViews.get(realPosition));
        container.addView(imageViews.get(position));

        /*if (bannerListener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bannerListener.OnBannerClick(position);
                }
            });
        }
        if (listener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnBannerClick(toRealPosition(position));
                }
            });
        }*/
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}