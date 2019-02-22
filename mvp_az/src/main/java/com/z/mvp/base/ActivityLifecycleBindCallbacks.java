package com.z.mvp.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.z.mvp.base.view.IActivity;
import com.z.mvp.base.view.IView;


/**
 * 本类是Activity生命周期监听器.在{@link ApplicationMostBasic}中注册了该监听.
 * 监听了所有的Activity生命周期,以便在application中提供current activity.如果activity实现了{@link IView}
 * 接口则绑定activity生命周期至持有的presenter.如果activity派生至FragmentActivity,且实现了{@link IActivity}
 * 接口,且IActivity方法hasFragment()返回true,则监听fragment生命周期{@link FragmentLifecycleBindCallbacks}.
 * <p>
 * Created by Az
 * on 2019/2/22.
 */
public class ActivityLifecycleBindCallbacks implements Application.ActivityLifecycleCallbacks {

    private ApplicationMostBasic mApplication;

    ActivityLifecycleBindCallbacks(ApplicationMostBasic application) {
        this.mApplication = application;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity instanceof IView && ((IView) activity).peekPresenter() != null) {
            ((IView) activity).peekPresenter().onViewCreate();
        }
        //绑定fragment生命周期
        if (activity instanceof FragmentActivity && activity instanceof IActivity && ((IActivity) activity).hasFragment()) {
            final FragmentManager fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            fragmentManager.registerFragmentLifecycleCallbacks(new FragmentLifecycleBindCallbacks(), true);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if (activity instanceof IView && ((IView) activity).peekPresenter() != null) {
            ((IView) activity).peekPresenter().onViewStart();
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        mApplication.setCurrentActivity(activity);
        if (activity instanceof IView && ((IView) activity).peekPresenter() != null) {
            ((IView) activity).peekPresenter().onViewResume();
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        mApplication.setCurrentActivity(null);
        if (activity instanceof IView && ((IView) activity).peekPresenter() != null) {
            ((IView) activity).peekPresenter().onViewPause();
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {
        if (activity instanceof IView && ((IView) activity).peekPresenter() != null) {
            ((IView) activity).peekPresenter().onViewStop();
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        if (activity instanceof IView && ((IView) activity).peekPresenter() != null) {
            ((IView) activity).peekPresenter().onViewStop();
        }
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activity instanceof IView && ((IView) activity).peekPresenter() != null) {
            ((IView) activity).peekPresenter().onViewDestroy();
        }
    }

}
