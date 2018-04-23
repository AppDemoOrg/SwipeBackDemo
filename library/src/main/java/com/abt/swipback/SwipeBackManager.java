package com.abt.swipback;

import android.app.Activity;
import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

import com.abt.swipback.widget.SwipeBackLayout;
import com.abt.swipback.widget.ViewUtil;

/**
 * @描述：     @右滑删除
 * @作者：      @黄卫旗
 * @创建时间： @2018-04-23
 */
public class SwipeBackManager {
    private static final String TAG = SwipeBackManager.class.getSimpleName();

    private static SwipeBackConfig sSwipeBackConfig;
    private static ActivityMgr sActivityManage;

    public static final void initialize(Application application, SwipeBackConfig config) {
        if (null == sSwipeBackConfig) {
            sSwipeBackConfig = config;
            sActivityManage = new ActivityMgr();
            application.registerActivityLifecycleCallbacks(sActivityManage);
        }
    }

    private SwipeBackManager() {

    }

    public static final SwipeBackConfig getSwipBackConfig() {
        return sSwipeBackConfig;
    }

    /**
     * 把当前
     * @param curActivity
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static final void addSwipeBackList(@NonNull final Activity curActivity) {
        final ViewGroup decorView = ViewUtil.getDecorView(curActivity);
        final View contentView    = decorView.getChildAt(0);
        decorView.removeViewAt(0);

        View content = contentView.findViewById(android.R.id.content);
        if (content.getBackground() == null) {
            content.setBackground(decorView.getBackground());
        }

        final Activity[] preActivity      = {sActivityManage.getPreActivity()};
        final View[] preContentView       = {ViewUtil.getContentView(preActivity[0])};
        Drawable preDecorViewDrawable      = ViewUtil.getDecorViewDrawable(preActivity[0]);
        content = preContentView[0].findViewById(android.R.id.content);
        if (content.getBackground() == null) {
            content.setBackground(preDecorViewDrawable);
        }

        final SwipeBackLayout layout = new SwipeBackLayout(curActivity, contentView,
                preContentView[0], preDecorViewDrawable,
                new SwipeBackLayout.OnInternalStateListener() {
                    @Override
                    public void onSlide(float percent) {

                    }

                    @Override
                    public void onOpen() {

                    }

                    @Override
                    public void onClose(Boolean finishActivity) {
                        if (getSwipBackConfig() != null && getSwipBackConfig().isRotateScreen()) {
                            if (finishActivity != null && finishActivity) {
                                // remove了preContentView后布局会重新调整，这时候contentView回到原处，所以要设不可见
                                contentView.setVisibility(View.INVISIBLE);
                            }
//                            if (preActivity[0] != null && preContentView[0].getParent() != ViewUtil.getDecorView(preActivity[0])) {
//                                preContentView[0].setX(0);
//                                ((ViewGroup) preContentView[0].getParent()).removeView(preContentView[0]);
//                                ViewUtil.getDecorView(preActivity[0]).addView(preContentView[0], 0);
//                            }
                        }

                        if (finishActivity != null && finishActivity) {
                            curActivity.finish();
                            curActivity.overridePendingTransition(0, R.anim.anim_out_none);
                            sActivityManage.postRemoveActivity(curActivity);
                        } else if (finishActivity == null) {
                            sActivityManage.postRemoveActivity(curActivity);
                        }
                    }

                    @Override
                    public void onCheckPreActivity(SwipeBackLayout slideBackLayout) {
                        Activity activity = sActivityManage.getPreActivity();

                    }
                });
        decorView.addView(layout);
    }

}
