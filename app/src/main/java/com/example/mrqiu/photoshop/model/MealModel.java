package com.example.mrqiu.photoshop.model;

import com.example.mrqiu.photoshop.bean.MealBean;
import com.example.mrqiu.photoshop.info.ApiHttp;
import com.example.mrqiu.photoshop.info.ApiUrl;
import com.example.mrqiu.photoshop.info.OnCallbackListListener;

import okhttp3.Address;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class MealModel {
    /**
     * 获取优惠列表
     *
     * @param province
     * @param city
     * @param page
     * @param pageSize
     * @param listener
     */
    public static void meal(String province, String city, int page, int pageSize, OnCallbackListListener<MealBean> listener) {
        ApiHttp.post(MealBean.class)
                .tag(MealModel.class)
                .addParams("province", province)
                .addParams("city", city)
                .addParams("page", page)
                .addParams("pageSize", pageSize)
                .url(ApiUrl.meal_query_select)
                .build()
                .execute(listener);
    }

    /**
     * 通过shopId获得
     *
     * @param shopId
     * @param page
     * @param pageSize
     * @param listener
     */
    public static void mealForShopId(String shopId, int page, int pageSize, OnCallbackListListener<MealBean> listener) {
        ApiHttp.post(MealBean.class)
                .tag(MealModel.class)
                .addParams("shopId", shopId)
                .addParams("page", page)
                .addParams("pageSize", pageSize)
                .url(ApiUrl.meal_query_shop)
                .build()
                .execute(listener);
    }

    /**
     * 通过shopId获得
     *
     * @param userId
     * @param page
     * @param pageSize
     * @param listener
     */
    public static void mealForUserId(String userId, int page, int pageSize, OnCallbackListListener<MealBean> listener) {
        ApiHttp.post(MealBean.class)
                .tag(MealModel.class)
                .addParams("shopId", userId)
                .addParams("page", page)
                .addParams("pageSize", pageSize)
                .url(ApiUrl.meal_query_user)
                .build()
                .execute(listener);
    }
}