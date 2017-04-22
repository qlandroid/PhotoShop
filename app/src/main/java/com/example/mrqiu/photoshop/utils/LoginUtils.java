package com.example.mrqiu.photoshop.utils;

/**
 * Created by mrqiu on 2017/4/22.
 */

public class LoginUtils {
    private String mFileName = "login";
    private String key_is_login = "isLogin";
    private String key_is_first = "isFirst";
    private String key_account = "account";
    public  boolean isLogin(){
       return PreferencesUtils.get(mFileName,key_is_login,false);
    }
    public boolean isFirstLogin(){
        return PreferencesUtils.get(mFileName,key_is_first,false);
    }

    public String getAccount(){
        return PreferencesUtils.get(mFileName,key_account,"");
    }
    public void setIsLogin(boolean isLogin){
        PreferencesUtils.save(mFileName,key_is_login,isLogin);
    }
    public void setIsFirstLogin(boolean isFirstLogin){
        PreferencesUtils.save(mFileName,key_is_first,isFirstLogin);
    }
    public void setAccount(String account){
        PreferencesUtils.save(mFileName,key_account,account);
    }

}
