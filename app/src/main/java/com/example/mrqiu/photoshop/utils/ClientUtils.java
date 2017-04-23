package com.example.mrqiu.photoshop.utils;

import com.example.mrqiu.photoshop.bean.ClientUserBean;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class ClientUtils {
    private static final String FILE_NAME = "client";

    private static final String KEY_ID = "keyUserId";
    public static String getUserId(){
        return PreferencesUtils.get(FILE_NAME,KEY_ID,"");
    }

    public static void saveClientUser(ClientUserBean userBean){
        PreferencesUtils.save(FILE_NAME,KEY_ID,userBean.getObjectId());
    }

    public static void del(){
        PreferencesUtils.del(FILE_NAME);
    }
}
