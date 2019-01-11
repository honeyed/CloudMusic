package com.t.cloudmusic.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BActivity;
import com.t.cloudmusic.ui.main.MainActivity;

public class CheckVerificationCodeActivity extends BActivity<LoginContract.LoginPresenter> implements View.OnClickListener {

//    private EditText codeOne,codeTwo,codeThree,codeFour;
    private String inputContent = "";
    private int[] editTextIds = {R.id.codeOne,R.id.codeTwo,R.id.codeThree,R.id.codeFour};
    private EditText[] editTexts = new EditText[4];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_v_code);
        for (int i = 0;i<editTextIds.length;i++) {
            editTexts[i] = findViewById(editTextIds[i]);
            editTexts[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    requestFocus();
                    return true;
                }
            });
            addTextChangeListener(editTexts[i]);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.codeOne:
                requestFocus();
                break;
            case R.id.codeTwo:
                requestFocus();
                break;
            case R.id.codeThree:
                requestFocus();
                break;
            case R.id.codeFour:
                requestFocus();
                break;
        }
    }

    public void requestFocus() {
        for (int i = 0; i < editTexts.length; i++) {
            if(editTexts[i].getText().toString().equals("")) {
                editTexts[i].requestFocus();
                editTexts[i].setFocusableInTouchMode(true);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editTexts[i], 0);
                editTexts[i].setBackgroundResource(R.drawable.line_shape_bottom_line_ready);
                break;
            } else {
                editTexts[i].setBackgroundResource(R.drawable.line_shape_bottom_line_red);
                if(i == 3) {
                    Intent intent = new Intent(CheckVerificationCodeActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//关掉所要到的界面中间的activity
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//设置不要刷新将要跳转的界面
                    Log.e("checkFlags", intent.getFlags()+"");
                    startActivity(intent);
                }
            }
        }
    }

    /**
     * && event.getAction() != KeyEvent.ACTION_UP 防止执行两次
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_DEL && event.getAction() != KeyEvent.ACTION_UP) {
            for (int i = 3; i > -1; i--) {
                if (!editTexts[i].getText().toString().equals("")) {
                    editTexts[i].setText("");
                    break;
                } else {
                    if (i != 0)
                        editTexts[i].setBackgroundResource(R.drawable.line_shape_bottom_line);
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    public void addTextChangeListener(EditText et) {
        et.addTextChangedListener(textWatcher);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            requestFocus();
        }
    };

    @Override
    public LoginContract.LoginPresenter newP() {
        return null;
    }
}
