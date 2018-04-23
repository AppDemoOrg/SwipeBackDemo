package com.abt.swipeback;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.abt.swipeback.basic.SwipeBackActivity;

public class NextActivity extends SwipeBackActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static final void startActivity(Activity context) {
        Intent intent = new Intent(context, NextActivity.class);
        context.startActivity(intent);
    }
}
