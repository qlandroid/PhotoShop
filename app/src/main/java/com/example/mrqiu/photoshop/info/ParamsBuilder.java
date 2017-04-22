package com.example.mrqiu.photoshop.info;

import java.util.Map;
import java.util.Objects;

/**
 * Created by mrqiu on 2017/4/22.
 */

public abstract class ParamsBuilder {
    public Class aClass;
    public String url;
    public Map<String,Object> mParams;
    public Map<String,String> mHeader;
    public Object mTag;

    public ParamsBuilder(Class aClass) {
        this.aClass = aClass;
    }
}
