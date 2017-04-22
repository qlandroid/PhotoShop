package com.example.mrqiu.photoshop.utils;

import com.example.mrqiu.photoshop.C;
import com.example.mrqiu.photoshop.bean.A_ResultBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by mrqiu on 2017/4/22.
 */

public class DataUtils {

    public static <T> T getObject(String resultJson,Class clazz){
        return (T) C.sGson.fromJson(resultJson,clazz);
    }

    public static  ArrayList getDataList(Object resultObj,Class clazz){
        Gson gson = C.sGson;
        List<Map<?,?>> resultList = (List<Map<?, ?>>) resultObj;
        ArrayList list = new ArrayList();
        for (int i = 0; i < resultList.size(); i++) {
            String itemJson = gson.toJson(resultList.get(i));

            list.add(gson.fromJson(itemJson,clazz));
        }
        return list;
    }

    public static <T> T getDataObject(Object dataObj, Class<A_ResultBean> classOfT) {
        Gson gson = C.sGson;
        return (T) gson.fromJson(gson.toJson(dataObj), classOfT);
    }



}
