package com.abt.swipeback;

import android.app.Application;

import com.abt.swipback.SwipeBackConfig;
import com.abt.swipback.SwipeBackManager;

/**
 * Created by hwq on 2018/4/23.
 */
public class SwipeBackApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSwipeBack();
    }

    private final void initSwipeBack(){
        SwipeBackManager.initialize(this,new SwipeBackConfig.Builder().
                edgeOnly(false).lock(false).rotateScreen(false).create());
    }

}
