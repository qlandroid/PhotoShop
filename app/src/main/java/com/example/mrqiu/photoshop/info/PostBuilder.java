package com.example.mrqiu.photoshop.info;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by mrqiu on 2017/4/22.
 */

public class PostBuilder extends ParamsBuilder {

    public PostBuilder(Class aClass) {
        super(aClass);
    }

    public PostBuilder url(String url) {
        this.url = url;
        return this;
    }

    public PostBuilder addParams(String key,Object value) {
        if (mParams == null){
            mParams = new HashMap<>();
        }
        mParams.put(key,value);
        return this;
    }

    public PostBuilder params(Map<String,Object> params) {
        mParams = params;
        return this;
    }

    public PostBuilder addHeader(String key,String value) {
        if (mHeader == null){
            mHeader = new HashMap<>();
        }
        mHeader.put(key,value);
        return this;
    }

    public PostBuilder tag(Object tag){
        mTag = tag;
        return this;
    }
    public HttpRun build(){
        return new HttpRun(aClass,url,mHeader,mParams,mTag);
    }
}
