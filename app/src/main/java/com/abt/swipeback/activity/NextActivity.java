package com.abt.swipeback.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.abt.swipeback.R;
import com.abt.swipebacklib.basic.SwipeBackActivity;

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

    public void toEndActivity(View view) {
        NextActivity.this.finish();
    }
}
