package com.t.cloudmusic.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class LoginButton extends AppCompatButton {

    private List<EditText> textWatchers;

    public LoginButton(Context context) {
        super(context);
        init();
    }

    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoginButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setClickable(false);
        textWatchers = new ArrayList<>();
    }

    @Override
    public void setClickable(boolean clickable) {
        super.setClickable(clickable);
        if(clickable)
            setTextColor(Color.WHITE);
        else
            setTextColor(Color.GRAY);
    }

    public void addEditTextClick(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean isClickAble = true;
                for (int i = 0; i < textWatchers.size(); i++) {
                    if (textWatchers.get(i).getText().toString().equals("")) {
                        isClickAble = false;
                        break;
                    }
                }
                setClickable(isClickAble);
            }
        });
        textWatchers.add(editText);
    }


}
