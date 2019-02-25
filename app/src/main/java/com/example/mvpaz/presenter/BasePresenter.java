package com.example.mvpaz.presenter;

import android.support.annotation.NonNull;

import com.example.mvpaz.ApplicationMvp;
import com.z.mvp.base.presenter.IPresenter;
import com.z.mvp.base.presenter.MostBasicPresenter;
import com.z.mvp.base.view.IView;

public abstract class BasePresenter<M, V extends IView<ApplicationMvp, ? extends IPresenter>>
        extends MostBasicPresenter<M, V, ApplicationMvp> {

    public BasePresenter(@NonNull V view) {
        super(view);
    }

}
