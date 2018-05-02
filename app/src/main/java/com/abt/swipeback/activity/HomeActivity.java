package com.abt.swipeback.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.abt.swipeback.R;
import com.abt.swipebacklib.basic.SwipeBackActivity;

/**
 * Created by hwq on 2018/4/23.
 */
public class HomeActivity extends SwipeBackActivity {

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
        setContentView(R.layout.activity_home);
    }

    public void toMainActivity(View view) {
        MainActivity.startActivity(HomeActivity.this);
    }

    public void toSingleTaskActivity(View view) {
        SingleTaskActivity.startActivity(HomeActivity.this);
    }
}
