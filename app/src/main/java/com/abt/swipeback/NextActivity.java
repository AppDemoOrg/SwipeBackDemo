package com.abt.swipeback;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.abt.swipeback.basic.SwipeBackActivity;

/**
 * Created by hwq on 2018/4/23.
 */
public class NextActivity extends SwipeBackActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    public static final void startActivity(Activity context) {
        Intent intent = new Intent(context, NextActivity.class);
        context.startActivity(intent);
    }
}
