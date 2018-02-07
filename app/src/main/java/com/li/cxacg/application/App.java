package com.li.cxacg.application;


import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class App extends Application {
    private static App mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        //日志
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
    public static App getInstance() {
        return mInstance;
    }
}
