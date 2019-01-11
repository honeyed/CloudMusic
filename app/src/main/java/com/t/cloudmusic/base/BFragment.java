package com.t.cloudmusic.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t.cloudmusic.widget.dialog.LoadingProgressDialog;

/**
 * Created by 田洪龙 on 2018/6/28. 自定义可以截取activity中返回按钮的监听方法
 */
public abstract class BFragment<P extends IPresenter> extends Fragment implements IView<P> {
    protected IBackHandledInterface mBackHandledInterface;
    protected View contentView;
    private P p;
    private LoadingProgressDialog loadingProgressDialog;

    /**
     * 所有继承BackHandledFragment的子类都将在这个方法中实现物理Back键按下后的逻辑
     * FragmentActivity捕捉到物理返回键点击事件后会首先询问Fragment是否消费该事件
     * 如果没有Fragment消息时FragmentActivity自己才会消费该事件
     */
    public abstract boolean onBackPressed();// 返回true是执行fragment中的返回，返回false执行mainActivity中的返回


    public void showLoadingDialog(String msg) {

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof IBackHandledInterface)) {
            throw new ClassCastException(
                    "Hosting Activity must implement IBackHandledInterface");
        } else {
            this.mBackHandledInterface = (IBackHandledInterface) getActivity();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (null != contentView) {
            ViewGroup view = (ViewGroup) contentView.getParent();
            if (view != null)
                view.removeAllViews();
        } else {
            if (getLayoutId() != 0) {
                contentView = inflater.inflate(getLayoutId(), container, false);
                bindView();
            } else
                throw new RuntimeException(
                        "getViewById() can't return 0,please set id in getViewById();");
        }
        return contentView;
    }

    protected abstract int getLayoutId();

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }


    /**
     * 绑定控件
     */
    protected abstract void bindView();

    /**
     * @param id the id of the view to be found
     * @return the view of the specified id, null if cannot be found
     * @hide
     */
    protected <T extends View> T findViewById(@IdRes int id) {
        if (id == id) {
            return (T) contentView.findViewById(id);
        }
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        // 告诉FragmentActivity，当前Fragment在栈顶
        mBackHandledInterface.setSelectedFragment(this);
    }

    /**
     * <a>供activity中执行刷新某个Fragment所用
     */
    public void refreshDate() {

    }

    public <T> void startActivity(Class<T> info) {
        Intent intent = new Intent(getActivity(), info);
        startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
//		getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getP() != null) {
            getP().detachV();
        }
        p = null;
    }
}
