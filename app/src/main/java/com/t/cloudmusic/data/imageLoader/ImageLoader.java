package com.t.cloudmusic.data.imageLoader;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class ImageLoader {

    public static void loadImage(Context context, ImageView imageView,String url) {
        Glide.with(context)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade())
                .into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView,int url) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
//    int dpToPx(int dps) {
//        return Math.round(getResources().getDisplayMetrics().density * dps);
//    }
}
