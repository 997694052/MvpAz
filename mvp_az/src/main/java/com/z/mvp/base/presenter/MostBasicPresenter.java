package com.z.mvp.base.presenter;

import android.app.Application;
import android.support.annotation.NonNull;

import com.z.mvp.base.view.IView;

/**
 * 在框架层对IPresenter进行了基本实现.应用的presenter只需要实现{@link IPresenter}即可,继承本类是可选的.
 *
 * @param <M> presenter持有的model类型,具体类型在IPresenter的最终实现类中确定.
 * @param <V> presenter持有的view类型,具体类型在IPresenter的最终实现类中确定.
 * @param <A> presenter持有的应用Application类型,具体类型在应用中确定.
 *            <p>
 *            Created by Az
 *            on 2019/2/22.
 */
public abstract class MostBasicPresenter<M, V extends IView<A, ? extends IPresenter>, A extends Application>
        implements IPresenter<M> {

    protected M mModel;         //持有的model
    protected V mView;          //持有的view
    protected A mApplication;   //应用的application

    public MostBasicPresenter(@NonNull V view) {
        this.mView = view;
        this.mApplication = view.peekApplication();
        this.mModel = createModel();
    }


    @Override
    public void onViewCreate() {

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewResume() {

    }

    @Override
    public void onViewPause() {

    }

    @Override
    public void onViewStop() {

    }

    @Override
    public void onViewDestroy() {

    }

}
