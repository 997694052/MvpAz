package com.z.mvp.base.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.z.mvp.base.presenter.IPresenter;

/**
 * Fragment的默认实现.
 * 应用的fragment继承该类是可选的,只需要实现{@link IView}即可.
 * 注意资源回收的时机.{@link #onDetach()}.
 *
 * @param <A> 应用的application,具体类型在应用中确定.
 * @param <P> Fragment持有的presenter,具体类型在IView的最终Fragment实现类中确定.
 *            Created by Az
 *            on 2019/2/25.
 */
public abstract class MostBasicFragment<A extends Application, P extends IPresenter>
        extends Fragment
        implements IView<A, P> {

    protected P mPresenter;
    protected Toast mToast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mPresenter = createPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 在onDetach中回收资源.
     * onDetach在onDestroy之后执行.如果在Destroy中回收presenter,会导致fragment生命周期监听中判断presenter
     * 为空,presenter无法接收fragment的onDestroy事件.这里和activity不同.activity在onDestroy中执行supper
     * 后会触发生命周期监听器的对应方法,而fragment会在onDestroy方法执行完后再触发对应的生命周期监听器函数.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter = null;
        mToast = null;
    }

    @Override
    public P peekPresenter() {
        return mPresenter;
    }

}
