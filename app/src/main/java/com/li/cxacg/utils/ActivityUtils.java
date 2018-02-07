package com.li.cxacg.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Created by ZHT on 2017/4/17.
 * Activity管理工具类(包含对Fragment的添加切换)
 */

public enum  ActivityUtils {
    INSTANCE();
    ActivityUtils() {
        mActivityStack = new Stack<>();
    }
    private Stack<Activity> mActivityStack;

    /**
     * 添加一个Activity到堆栈中
     */
    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<>();
        }
        mActivityStack.push(activity);
    }
    /**
     * 获取到当前显示Activity（堆栈中最后一个传入的activity）
     */
    public Activity getLastActivity() {
        if (mActivityStack != null)
            return mActivityStack.lastElement();
        else
            return null;
    }

    /**
     * 从堆栈中移除指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束除当前传入以外所有Activity
     */
    public void finishOthersActivity(Class<?> cls) {
        if (mActivityStack != null)
            for (Activity activity : mActivityStack) {
                if (!activity.getClass().equals(cls)) {
                    activity.finish();
                }
            }
    }

    /**
     * 结束除当前传入以外所有Activity
     */
    public void finishOthersActivity(Activity activity) {
        if (mActivityStack != null)
            for (Activity itemActivity : mActivityStack) {
                if (activity != itemActivity) {
                    itemActivity.finish();
                }
            }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (mActivityStack != null) {
            for (Activity activity : mActivityStack) {
                activity.finish();
            }
            mActivityStack.clear();
        }
    }

    /**
     * 退出应用程序
     * @param context
     */
    public void exitApp(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityManager = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.restartPackage(context.getPackageName());
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}