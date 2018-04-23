package com.abt.swipebacklib.basic;

import android.app.Application;

import com.abt.swipebacklib.SwipeBackConfig;
import com.abt.swipebacklib.SwipeBackManager;

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
        SwipeBackConfig config = new SwipeBackConfig.Builder().
                edgeOnly(false).lock(false).rotateScreen(false).create();
        SwipeBackManager.initialize(this, config);
    }

}
