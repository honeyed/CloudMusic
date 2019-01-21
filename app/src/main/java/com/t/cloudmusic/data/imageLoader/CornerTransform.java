package com.t.cloudmusic.data.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.NonNull;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;

import java.security.MessageDigest;

public class CornerTransform extends BitmapTransformation {


    private Bitmap circleCrop(BitmapPool pool, Bitmap toTransform) {
        if (toTransform == null) return null;

        int size = Math.min(toTransform.getWidth(), toTransform.getHeight());
        int x = (toTransform.getWidth() - size) / 2;
        int y = (toTransform.getHeight() - size) / 2;

        // TODO this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(toTransform, x, y, size, size);

        Bitmap result = pool.get(size, size, Bitmap.Config.RGB_565);
        if (result == null) {
            result = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);
        return result;
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool,toTransform);
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }
}