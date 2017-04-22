package com.example.mrqiu.photoshop.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mrqiu.photoshop.C;
import com.example.mrqiu.photoshop.MyApp;

import java.util.Set;
import java.util.zip.Deflater;

/**
 * Created by mrqiu on 2017/4/22.
 */

public class PreferencesUtils {

    public static void save(String fileName, String key, String value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static void save(String fileName, String key, boolean value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static void save(String fileName, String key, int value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static void save(String fileName, String key, long value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).commit();
    }

    public static void save(String fileName, String key, Set<String> value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().putStringSet(key, value).commit();
    }

    public static boolean get(String fileName, String key, boolean normal) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getBoolean(key, normal);
    }

    public static String get(String fileName, String key, String normal) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getString(key, normal);
    }

    public static long get(String fileName, String key, long normal) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getLong(key, normal);
    }

    public static Set<String> get(String fileName, String key, Set<String> normal) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getStringSet(key, normal);
    }


    public static void save(String key, String value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static void save(String key, boolean value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static void save(String key, int value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static void save(String key, long value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).commit();
    }

    public static void save(String key, Set<String> value) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        sp.edit().putStringSet(key, value).commit();
    }

    public static boolean get(String key, boolean normal) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        return sp.getBoolean(key, normal);
    }

    public static String get(String key, String normal) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        return sp.getString(key, normal);
    }

    public static long get(String key, long normal) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        return sp.getLong(key, normal);
    }

    public static Set<String> get(String key, Set<String> normal) {
        SharedPreferences sp = MyApp.getInstance().getSharedPreferences(C.sFileName, Context.MODE_PRIVATE);
        return sp.getStringSet(key, normal);
    }
}
