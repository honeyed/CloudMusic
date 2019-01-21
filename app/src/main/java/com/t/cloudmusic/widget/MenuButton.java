package com.t.cloudmusic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.t.cloudmusic.R;

import java.util.Calendar;

public class MenuButton extends RatioImageView {

    private int resId = 0;

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
//        Paint paint = new Paint();
//        //抗锯齿，不然很丑
//        paint.setAntiAlias(true);
////        给画笔设置颜色
//        paint.setColor(Color.parseColor("#e35b4a"));
////        设置画笔属性
//        paint.setStyle(Paint.Style.FILL);//画笔属性是实心圆
//        paint.setStrokeWidth(8);//设置画笔粗细
//        /*四个参数：
//                参数一：圆心的x坐标
//                参数二：圆心的y坐标
//                参数三：圆的半径
//                参数四：定义好的画笔
//                */
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth()/2, paint);
        super.onDraw(canvas);
        if(resId == R.mipmap.cm5_disc_topbtn_daily) {
            Paint textPaint = new Paint();
            textPaint.setColor(Color.WHITE);
            textPaint.setTextSize(40);
            textPaint.setStyle(Paint.Style.FILL);
            //该方法即为设置基线上那个点究竟是left,center,还是right  这里我设置为center
            textPaint.setTextAlign(Paint.Align.CENTER);

            Calendar cale = null;
            cale = Calendar.getInstance();
            canvas.drawText(cale.get(Calendar.DATE)+"", getWidth() / 2, getHeight() - getHeight() / 8 * 3, textPaint);
        }
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        this.resId = resId;
    }
}
