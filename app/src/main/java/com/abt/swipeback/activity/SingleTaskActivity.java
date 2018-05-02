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
 * @描述： @SingleTaskActivity
 * @作者： @黄卫旗
 * @创建时间： @2018/5/2
 */
public class SingleTaskActivity extends SwipeBackActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
    }

    public static final void startActivity(Activity context) {
        Intent intent = new Intent(context, SingleTaskActivity.class);
        context.startActivity(intent);
    }

    public void toEndActivity(View view) {
        SingleTaskActivity.this.finish();
    }

}
