package com.t.cloudmusic.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.t.cloudmusic.R;
import com.t.cloudmusic.common.SPUtils;
import com.t.cloudmusic.common.SP_Constant;
import com.t.cloudmusic.hook.NeedLoginActivity;
import com.t.cloudmusic.ui.login.LoginActivity;

public abstract class BActivity<P extends IPresenter> extends AppCompatActivity implements IView<P> {

    private Intent realIntent;
    private P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setTitle(String title) {
        TextView textView = findViewById(R.id.title);
        if(textView != null)
            textView.setText(title);
    }

    public void setTitle(int title) {
        TextView textView = findViewById(R.id.title);
        if(textView != null)
            textView.setText(title);
    }

    @Override
    protected void onResume() {
        super.onResume();
        View v = findViewById(R.id.backButton);
        if(v != null)
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivity(Intent intent) {
        if(isNeedLogin(intent)) {
            realIntent = intent;
            Intent loginIntent = new Intent(this, LoginActivity.class);
            if(this.getClass().getName().contains("com.t.cloudmusic.ui.login")) {
                loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//关掉所要到的界面中间的activity
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//设置不要刷新将要跳转的界面
            }
            startActivityForResult(loginIntent,100);
            return;
        }
        super.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode== RESULT_OK)
            startActivity(realIntent);
    }

    @Override
    public void showErrorMsg(String message) {

    }

    @Override
    public void showLoadingDialog(String msg) {

    }

    public boolean isNeedLogin(Intent intent) {
        String className = intent.getComponent().getClassName();
        return !SPUtils.getInstance().getBoolean(SP_Constant.IS_LOGIN, false) && new NeedLoginActivity().isNeedLogin(className);
    }

    protected P getP() {
        if (p == null) {
            p = newP();
        }
        if (p != null) {
            if (!p.hasV()) {
                p.attachV(this);
            }
        }
        return p;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getP() != null) {
            getP().detachV();
        }
    }
}
