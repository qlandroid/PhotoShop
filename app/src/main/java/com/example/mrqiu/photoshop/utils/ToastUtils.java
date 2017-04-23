package com.example.mrqiu.photoshop.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class ToastUtils {

    public static void toast(Context context, String content){
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
