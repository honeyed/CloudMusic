package com.t.cloudmusic.base;

public interface IPresenter<V extends IView> {

    void attachV(V view);

    void detachV();

    boolean hasV();
}