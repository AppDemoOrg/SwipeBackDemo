package com.abt.swipebacklib.basic;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.abt.swipebacklib.SwipeBackManager;
import com.orhanobut.logger.Logger;

/**
 * Created by hwq on 2018/4/23.
 */
public class SwipeBackActivity extends AppCompatActivity {

    protected final int LEFT_KEY_CODE = KeyEvent.KEYCODE_CAMERA;
    protected final int RIGHT_KEY_CODE = KeyEvent.KEYCODE_BACK;
    
    private CountDown mCountDown;
    private boolean mShortPress = false;
    private volatile boolean mCounting = false;

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Logger.d("onKeyDown() keyCode = " + keyCode);
        if (keyCode == RIGHT_KEY_CODE || keyCode == LEFT_KEY_CODE) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                listenLongPress();
                listenShortPress(event);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 监听长按事件
     */
    private void listenLongPress() {
        if (null != mCountDown && !mCounting) {
            mCountDown.cancel();
            mCountDown = null;
        } else if (mCountDown == null && !mCounting) {
            mCountDown = new CountDown(5 * 1000, 1000);
            mCountDown.start();
            mCounting = true;
        }
    }

    /**
     * 监听短按事件
     */
    private void listenShortPress(KeyEvent event) {
        event.startTracking();
        if (event.getRepeatCount() == 0) {
            mShortPress = true;
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == RIGHT_KEY_CODE || keyCode == LEFT_KEY_CODE) {
            if (mShortPress) { // 处理短按事件
                handleShortPress();
            } else { // 处理长按事件，这里什么都不用做，
                // 等长按5秒后在线程中跳转到Launcher
                // Don't handle long press here
            }
            mShortPress = false;
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    /**
     * 处理短按事件
     */
    private void handleShortPress() {
        if (null != mCountDown && mCounting) {
            mCountDown.cancel();
            mCountDown = null;
            mCounting = false;
            Logger.d( "Count Down Cancel()");
        }
        // Toast.makeText(this, "mShortPress", Toast.LENGTH_LONG).show();
    }

    /**
     * 处理长按返回Launcher倒计时
     */
    private class CountDown extends CountDownTimer {

        public CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            Logger.d( "CountDown millisInFuture = " + millisInFuture);
            Logger.d( "CountDown countDownInterval = " + countDownInterval);
        }

        @Override
        public void onTick(long l) {
            Logger.d( "onTick l = " + l);
        }

        @Override
        public void onFinish() {
            if (enableLongPressAction()) {
                onLongPressAction();
            } else {
                jumpToLauncher();
                jumpToLauncherAction();
            }
        }
    }

    protected void onLongPressAction(){};
    protected void jumpToLauncherAction(){};

    protected void jumpToLauncher() {
        Logger.d( "onFinish()");
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        SwipeBackActivity.this.startActivity(intent);
        //SwipeBackActivity.this.finish();
    }

    protected boolean enableLongPressAction() {
        return false;
    }

}
