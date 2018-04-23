package com.abt.swipeback;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.abt.swipeback.basic.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toNextActivity(View view) {
        NextActivity.startActivity(MainActivity.this);
    }
}
