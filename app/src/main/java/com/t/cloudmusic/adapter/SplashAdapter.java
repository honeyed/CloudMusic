package com.t.cloudmusic.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.t.cloudmusic.R;
import com.t.cloudmusic.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class SplashAdapter extends PagerAdapter {

    private List<ImageView> datas;
    private int[] imageList = {R.mipmap.b4b, R.mipmap.b4c, R.mipmap.b4d, R.mipmap.b4e};
    private Activity mContext;

    public SplashAdapter(Activity mContext) {
        this.mContext = mContext;
        datas = new ArrayList<>();
        for (int i = 0; i < imageList.length; i++) {
            ImageView imageView = new ImageView(mContext);
            datas.add(imageView);
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = datas.get(position);
        if(position==3) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MainActivity.class);
                    mContext.startActivity(intent);
                    mContext.finish();
                }
            });
        }
//        ImageLoader.loadImage(container.getContext(), view, imageList[position]);
        view.setImageResource(imageList[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(datas.get(position));
    }
}