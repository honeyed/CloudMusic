package com.t.cloudmusic.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.t.cloudmusic.R;

/**
 * 带删除图标的输入框
 */
public class EditTextWithDelete extends AppCompatEditText {

    private Context mContext;
    private Drawable mClearDrawable;
    private OnTelChange listener;

    private int DRAWABLE_LEFT = 0;
    private int DRAWABLE_TOP = 1;
    private int DRAWABLE_RIGHT = 2;
    private int DRAWABLE_BOTTOM = 3;
    private boolean isClick = false;

    public EditTextWithDelete(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public EditTextWithDelete(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public EditTextWithDelete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        mClearDrawable = ContextCompat.getDrawable(mContext, R.mipmap.akb);
        mClearDrawable.setBounds(10, 10, 10, 10);
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus && !getText().toString().equals(""))
                    setClearIconVisible(true);
                else
                    setClearIconVisible(false);
            }
        });
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setClearIconVisible(hasFocus() && length() > 0);
        String phone = getText().toString();
        if(listener !=null) {
//            if (Regular.isMobile(phone)) {
//                isClick = true;
//                listener.onTelChange(true);
//            } else if (isClick) {
//                isClick = false;
//                listener.onTelChange(false);
//            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Drawable drawable = getCompoundDrawables()[DRAWABLE_RIGHT];
                if (drawable != null && event.getX() <= getWidth() - getPaddingRight() && event.getX() >= getWidth() - getPaddingRight() - drawable.getBounds().width()) {
                    setText("");
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void  setOnTelChange(OnTelChange listener) {
        this.listener = listener;
    }

    public void setClearIconVisible(boolean visible) {
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[DRAWABLE_LEFT], null, visible == true ? mClearDrawable:null, null);
    }

    interface OnTelChange {
        void onTelChange(boolean isPhone);
    }
}