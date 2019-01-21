package com.t.cloudmusic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

public class RoundedImageView extends RatioImageView {

//    float width, height;

    public RoundedImageView(Context context) {
        super(context);
        init(context, null);
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
//
    private void init(Context context, AttributeSet attrs) {
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        if (Build.VERSION.SDK_INT < 18) {
//            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
//        width = getWidth();
//        height = getHeight();
    }

    //注意使用的时候关闭硬件加速
    @Override
    protected void onDraw(Canvas canvas) {
//        if (width >= 12 && height > 12) {
//            Path path = new Path();
//            path.moveTo(12, 0);
//            path.lineTo(width - 12, 0);
//            path.quadTo(width, 0, width, 12);
//            path.lineTo(width, height - 12);
//            path.quadTo(width, height, width - 12, height);
//            path.lineTo(12, height);
//            path.quadTo(0, height, 0, height - 12);
//            path.lineTo(0, 12);
//            path.quadTo(0, 0, 12, 0);
//            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
//            canvas.clipPath(path);
//        }
        super.onDraw(canvas);
    }
}
