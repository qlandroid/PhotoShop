package com.example.mrqiu.photoshop.utils;

import android.util.Log;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class LogUtils {
    private static final String TAG = "LogUtils";
    public static boolean isOpen = true;
    public static void i(String tag,String content){
        if (isOpen)
            Log.i(tag, content);
    }
    public static void i(String content){
        i(TAG,content);
    }
    public static void d(String tag,String content){
        if (isOpen)
            Log.d(tag, content);
    }
    public static void d(String content){
        d(TAG,content);
    }

    public static void e(String tag,String content){
        if (isOpen)
            Log.e(tag, content);
    }
    public static void e(String content){
        e(TAG,content);
    }
    public static void w(String tag,String content){
        if (isOpen) {
            Log.i(tag, content);
        }
    }
    public static void w(String content){
        w(TAG,content);
    }
}
