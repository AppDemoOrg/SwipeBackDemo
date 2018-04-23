package com.abt.swipebacklib.basic;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.abt.swipebacklib.SwipeBackManager;

/**
 * Created by hwq on 2018/4/23.
 */
public class SwipeBackActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (enableSwipeBack()) SwipeBackManager.addSwipeBackList(this);

    }

    /**
     * 是否启动滑动删除
     */
    protected boolean enableSwipeBack() {
        return true;
    }

}
