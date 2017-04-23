package com.example.mrqiu.photoshop.bean;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class ClientUserBean {
    //	{"code":"200","data":
    // {"account":"qiu44",
    // "createdAt":"2017-04-21 11:29:12"
    // ,"id":55,
    // "objectId":"288b02cd19"
    // ,"password":"qiuliang",
    // "updatedAt":"2017-04-21 11:29:12"}}
    private String objectId;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
