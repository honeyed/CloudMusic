package com.t.cloudmusic.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BActivity;
import com.t.cloudmusic.widget.LoginButton;

public class ResetPassActivity extends BActivity<LoginContract.LoginPresenter> implements View.OnClickListener {
    private LoginButton button;
    private EditText mobileNum,password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        setTitle("重设密码");
        button = findViewById(R.id.registerButton);
        mobileNum = findViewById(R.id.mobileNum);
        password = findViewById(R.id.password);
        button.addEditTextClick(mobileNum);
        button.addEditTextClick(password);
        mobileNum.setText("123");
        password.setText("123");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerButton:
                startActivity(new Intent(ResetPassActivity.this, CheckVerificationCodeActivity.class));
                break;
        }
    }

    @Override
    public LoginContract.LoginPresenter newP() {
        return null;
    }
}
