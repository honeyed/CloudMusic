package com.t.cloudmusic.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.t.cloudmusic.R;

public class RatioImageView extends AppCompatImageView {

    //宽高比例ImageView
    private final float ratio;

    public RatioImageView(Context context) {
        super(context);
        ratio = 1;
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取自定义属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        ratio = typedArray.getFloat(R.styleable.RatioImageView_ratio, 1.0f);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        ratio = typedArray.getFloat(R.styleable.RatioImageView_ratio, 1.0f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取宽度的模式和尺寸
        int heightSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpec = MeasureSpec.getMode(widthMeasureSpec);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (heightSize * ratio), heightSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
