package com.abt.swipebacklib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.Stack;

/**
 * @描述：     @activity统一管理类
 * @作者：      @黄卫旗
 * @创建时间： @2018-04-23
 */
public class ActivityMgr implements Application.ActivityLifecycleCallbacks {

    private static Stack<Activity> sActivityStack;

    public ActivityMgr() {

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (sActivityStack == null) {
            sActivityStack = new Stack<>();
        }
        sActivityStack.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

        sActivityStack.remove(activity);

    }

    public Activity getPreActivity() {
        if (sActivityStack == null) {
            return null;
        }
        int size = sActivityStack.size();
        if (size < 2) {
            return sActivityStack.elementAt(0);
        }
        return sActivityStack.elementAt(size - 2);
    }

    public void finishAllActivity() {
        if (sActivityStack == null) {
            return;
        }
        for (Activity activity : sActivityStack) {
            activity.finish();
        }
    }

    public void printAllActivity() {
        if (sActivityStack == null) {
            return;
        }
    }

    /**
     * 强制删掉activity，用于用户快速滑动页面的时候，因为页面还没来得及destroy导致的问题
     * @param activity 删掉的activity
     */
    void postRemoveActivity(Activity activity) {
        if (sActivityStack != null) {
            sActivityStack.remove(activity);
        }
    }

    final int size(){
        return sActivityStack.size();
    }

}
