package com.li.cxacg.utils;

import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.Logger;


/**
 * Log日志
 */

public class L {

    public static final boolean isDebug = BuildConfig.DEBUG;

    public static void d(String tag, String msg) {
        if (isDebug) {
            Logger.d(tag, msg);
        }
    }
    public static void e( String msg) {
        if (isDebug) {
            Logger.e(msg);
        }
    }
    public static void e(String tag, String msg) {
        if (isDebug) {
            Logger.e(tag, msg);
        }
    }
    public static void e(Class cls, String msg) {
        if (isDebug) {
            Logger.e(cls.getSimpleName(), msg);
        }
    }
}
