package com.example.mrqiu.photoshop;

import com.google.gson.Gson;

/**
 * Created by mrqiu on 2017/4/22.
 */

public class C {
    public static int sUiWidth;
    public static int sUiHeight;
    public static final Gson sGson = new Gson();
    public static final String sFileName = "preferences";

    public static final String P = "P_bean";
    public static final String sType = "mType";
    public static class Type{
        public static final String Type0 = "type0";
        public static final String Type1 = "type1";
        public static final String Type2 = "type2";
    }
}
