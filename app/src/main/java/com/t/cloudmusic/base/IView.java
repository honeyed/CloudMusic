package com.t.cloudmusic.base;

public interface IView<P> {

    void showErrorMsg(String message);

    void showLoadingDialog(String msg);

    P newP();
}