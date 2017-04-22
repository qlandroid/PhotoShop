package com.example.mrqiu.photoshop.info;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mrqiu on 2017/4/22.
 */

public class BindViewUtils {

    public static void initView(Activity aty){
        Class clazz =aty.getClass();
        Field[] f = clazz.getDeclaredFields();
        for (Field itemF : f){
            boolean isHave = itemF.isAnnotationPresent(BindView.class);
            if (isHave){
                BindView iv = itemF.getAnnotation(BindView.class);
                int id = iv.value();
                //拿到注解上的ID
                //拿到该类中的findViewById方法，对应传参为int类型
                Method byId = null;
                try {
                    byId = clazz.getMethod("findViewById", int.class);
                    //然后执行该findViewById的方法
                    Object invoke = byId.invoke(aty, id);
                    //如果属性是私有的就修改一些访问权限，以便于我们修改值
                    itemF.setAccessible(true);
                    //将拿到的参数设置到对应的属性上，大公告成
                    itemF.set(aty,invoke);


                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public static void initView(Fragment frg, View view){
        Class clazz =frg.getClass();
        Field[] f = clazz.getDeclaredFields();
        for (Field itemF : f){
            boolean isHave = itemF.isAnnotationPresent(BindView.class);
            if (isHave){
                BindView iv = itemF.getAnnotation(BindView.class);
                int id = iv.value();
                //拿到注解上的ID
                //拿到该类中的findViewById方法，对应传参为int类型
                Method byId = null;
                try {
                    //然后执行该findViewById的方法
                    Object invoke = view.findViewById(id);
                    //如果属性是私有的就修改一些访问权限，以便于我们修改值
                    itemF.setAccessible(true);
                    //将拿到的参数设置到对应的属性上，大公告成
                    itemF.set(frg,invoke);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
