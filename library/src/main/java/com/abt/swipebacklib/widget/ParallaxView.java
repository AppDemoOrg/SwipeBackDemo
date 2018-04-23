package com.abt.swipebacklib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * @描述：      @滑动时产生视觉差背景图
 * @作者：      @黄卫旗
 * @创建时间： @2018-04-23
 */
public class ParallaxView extends View {

    private View mParallaxView;

    public ParallaxView(Context context) {
        super(context);
    }

    public void drawParallarView(View parallar) {
        mParallaxView = parallar;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mParallaxView != null) {
            mParallaxView.draw(canvas);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mParallaxView = null;
    }
}
