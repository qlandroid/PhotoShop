package com.example.mrqiu.photoshop.info;

/**
 * Created by mrqiu on 2017/4/22.
 */

public interface OnCallbackObjectListener<T> {
    void onSuccess(T t);
    void onFails(Exception e);
}
