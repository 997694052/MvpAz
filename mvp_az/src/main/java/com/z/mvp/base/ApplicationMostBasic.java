package com.z.mvp.base;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.multidex.MultiDexApplication;


/**
 * 分包插件.
 * 应用必须继承该Application,并设置为应用的Application.
 * <p>
 * Create by Az
 * on 20192/1.
 */
public class ApplicationMostBasic extends MultiDexApplication {

    private Activity mCurrentActivity;   //当前活动的Activity，当应用处于后台时，该值为null

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleBindCallbacks(this));
    }

    public @Nullable
    Activity currentActivity() {
        return mCurrentActivity;
    }

    void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
    }

}
