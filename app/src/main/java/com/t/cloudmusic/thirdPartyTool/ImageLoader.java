package com.t.cloudmusic.thirdPartyTool;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {

    public static void loadImage(Context context, ImageView imageView,String url) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView,int url) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
