package com.example.mrqiu.photoshop.info;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class ApiHttp {

    public static PostBuilder post(Class clazz){
        return new PostBuilder(clazz);
    }
}
