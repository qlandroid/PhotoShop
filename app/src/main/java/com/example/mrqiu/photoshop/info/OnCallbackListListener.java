package com.example.mrqiu.photoshop.info;

import java.util.ArrayList;

/**
 * Created by mrqiu on 2017/4/22.
 */
public interface OnCallbackListListener<T> {
    void onSuccess(ArrayList<T> list);
    void onFails(Exception e);
}
