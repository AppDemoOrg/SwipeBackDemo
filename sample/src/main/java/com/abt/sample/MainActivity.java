package com.abt.sample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.abt.swipebacklib.basic.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {

    /**
     * 首页需要禁用
     */
    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
