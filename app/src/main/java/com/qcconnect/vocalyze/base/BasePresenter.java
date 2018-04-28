package com.qcconnect.vocalyze.base;

/**
 * Created by evanalmonte on 4/28/18.
 */

public interface BasePresenter<T> {
    void onViewAttached(T view);

    void onViewDetached();
}