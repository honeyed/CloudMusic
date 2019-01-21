package com.t.cloudmusic.data.imageLoader;

import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.support.design.widget.TabLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

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
//    int dpToPx(int dps) {
//        return Math.round(getResources().getDisplayMetrics().density * dps);
//    }

    public static void loadRoundImage(Context mContext, ImageView mImgRound,String imgUrl) {
//        loadImage(mContext,mImgRound,imgUrl);
        GlideApp.with(mContext)
                .load(imgUrl)
                //设置等待时的图片【这个时候需要注释，否则这个会作为背景图】
                //.placeholder(R.drawable.img_loading)
                //设置加载失败后的图片显示
//                .error(R.drawable.img_error)
//                .centerCrop()
//                .override(imageWidthSize,imageHeightSize)
                //默认淡入淡出动画
//                .transition(withCrossFade())
                //缓存策略,跳过内存缓存【此处应该设置为false，否则列表刷新时会闪一下】
//                .skipMemoryCache(false)
                //缓存策略,硬盘缓存-仅仅缓存最终的图像，即降低分辨率后的（或者是转换后的）
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //设置图片加载的优先级
//                .priority(Priority.HIGH)
                .transform(new RoundedCornersTransformation(dip2px(mContext,4),0))
                .into(mImgRound);
    }

    /**
     * dp转px
     * 16dp - 48px
     * 17dp - 51px*/
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)((dpValue * scale) + 0.5f);
    }
}
