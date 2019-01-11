package com.t.cloudmusic.base;

import java.lang.ref.WeakReference;

public abstract class BPresenter<V extends IView> implements IPresenter<V> {

    private WeakReference<V> v;

    @Override
    public void attachV(V view) {
        v = new WeakReference<V>(view);
    }

    @Override
    public void detachV() {
        if (v.get() != null) {
            v.clear();
        }
        v = null;
    }

    protected V getV() {
        if (v == null || v.get() == null) {
            throw new IllegalStateException("v can not be null");
        }
        return v != null ? v.get() : null;
    }

    @Override
    public boolean hasV() {
        return v != null && v.get() != null;
    }
}
