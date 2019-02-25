package com.z.mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.z.mvp.base.view.IView;

/**
 * 本类是fragment的生命周期监听器.
 * 监听器在activity onCreate时注册.只有当一个activity派生至FragmentActivity,
 * 且实现了{@link com.z.mvp.base.view.IActivity}接口,且hasFragment()方法返回true时,才会监听其内部的fragment.
 * 监听了fragment的生命周期,如果fragment实现了{@link IView}接口,且持有的presenter不为null,则绑定生命
 * 周期至所持有的presenter.
 * <p>
 * Created by Az
 * on 2019/2/25
 */
public class FragmentLifecycleBindCallbacks extends FragmentManager.FragmentLifecycleCallbacks {

    @Override
    public void onFragmentViewCreated(@NonNull FragmentManager fm, @NonNull Fragment f, @NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onFragmentViewCreated(fm, f, v, savedInstanceState);
        if (f instanceof IView && ((IView) f).peekPresenter() != null) {
            ((IView) f).peekPresenter().onViewCreated();
        }
    }

    @Override
    public void onFragmentStarted(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentStarted(fm, f);
        if (f instanceof IView && ((IView) f).peekPresenter() != null) {
            ((IView) f).peekPresenter().onViewStarted();
        }
    }

    @Override
    public void onFragmentResumed(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentResumed(fm, f);
        if (f instanceof IView && ((IView) f).peekPresenter() != null) {
            ((IView) f).peekPresenter().onViewResumed();
        }
    }

    @Override
    public void onFragmentPaused(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentPaused(fm, f);
        if (f instanceof IView && ((IView) f).peekPresenter() != null) {
            ((IView) f).peekPresenter().onViewPaused();
        }
    }

    @Override
    public void onFragmentStopped(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentStopped(fm, f);
        if (f instanceof IView && ((IView) f).peekPresenter() != null) {
            ((IView) f).peekPresenter().onViewStopped();
        }
    }

    @Override
    public void onFragmentDestroyed(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentDestroyed(fm, f);
        if (f instanceof IView && ((IView) f).peekPresenter() != null) {
            ((IView) f).peekPresenter().onViewDestroyed();
        }
    }

}
