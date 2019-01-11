package com.t.cloudmusic.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BActivity;
import com.t.cloudmusic.common.SPUtils;
import com.t.cloudmusic.common.SP_Constant;
import com.t.cloudmusic.ui.main.MainActivity;
import com.t.cloudmusic.widget.LoginButton;

public class LoginByMobilActivity extends BActivity<LoginContract.LoginPresenter> implements View.OnClickListener,LoginContract.LoginView {

    private LoginButton button;
    private EditText mobileNum,password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_by_mobile);
        setTitle("手机号登录");
        button = findViewById(R.id.loginButton);
        mobileNum = findViewById(R.id.mobileNum);
        password = findViewById(R.id.password);
        button.addEditTextClick(mobileNum);
        button.addEditTextClick(password);
        mobileNum.setText("123");
        mobileNum.setSelection(3);
        password.setText("123");

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                getP().doLogin(mobileNum.getText().toString(), password.getText().toString());
                break;
            case R.id.visitor:
                startActivity(new Intent(LoginByMobilActivity.this, ResetPassActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void loginSuccess() {
        SPUtils.getInstance().putBoolean(SP_Constant.IS_LOGIN, true);
        Intent intent = new Intent(LoginByMobilActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFailed(int state, String message) {

    }

    @Override
    public LoginPresenter newP() {
        return new LoginPresenter();
    }
}
