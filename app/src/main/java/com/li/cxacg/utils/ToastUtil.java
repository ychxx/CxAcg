package com.li.cxacg.utils;

import android.content.Context;
import android.widget.Toast;

import com.li.cxacg.application.App;

/**
 * 吐司提示工具类
 */

public class ToastUtil {
    public static void show(String msg) {
        Toast.makeText(App.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void show(String msg, int time) {
        Toast.makeText(App.getInstance(), msg, time).show();
    }

    public static void show(String msg, Context context) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void show(String msg, Context context, int time) {
        Toast.makeText(context, msg, time).show();
    }
}
