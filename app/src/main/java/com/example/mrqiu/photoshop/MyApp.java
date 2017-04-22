package com.example.mrqiu.photoshop;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by mrqiu on 2017/4/22.
 */

public class MyApp extends Application {
    private  static MyApp mApp ;

    @Override
    public void onCreate() {
        super.onCreate();
        final MyApp app = this;
        mApp = app;
        Bmob.initialize(this,"3d031761911f67a38abca7fbf0ad4a7");
    }

    public static MyApp getInstance() {
        return mApp;
    }
}
