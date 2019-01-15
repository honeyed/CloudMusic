package com.t.cloudmusic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class MenuButton extends AppCompatImageView {

    private Paint mPaint;

    public MenuButton(Context context) {
        super(context);
    }

    public MenuButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
//        int dy = (fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom ;
//        int baseLine = getHeight()/2 + dy ;
//        int x = getPaddingLeft() ;
//        canvas.drawText(mText , x, baseLine, mPaint);
    }
}
