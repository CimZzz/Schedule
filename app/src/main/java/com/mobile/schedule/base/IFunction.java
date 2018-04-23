package com.mobile.schedule.base;

public interface IFunction<T extends IPresenter> {
    void onInit(T t);
    void onResume();
    void onPause();
    void onDestroy();
}