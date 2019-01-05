package com.t.cloudmusic.base;

public interface BaseView<T> {
    void setPresenter(T presenter);

    void showErrorMsg(String message);

    void showLoadingDialog(String msg);
}