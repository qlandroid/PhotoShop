package com.example.mrqiu.photoshop.utils;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class BusEvent {

    private static BusEvent mBusEvent;
    public static BusEvent getInstance() {
        if (mBusEvent == null){
            synchronized (BusEvent.class){
                if (mBusEvent == null){
                    mBusEvent = new BusEvent();
                }
            }
        }
        return mBusEvent;
    }
}
