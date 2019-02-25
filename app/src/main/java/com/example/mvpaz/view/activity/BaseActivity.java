package com.example.mvpaz.view.activity;

import android.app.Application;

import com.example.mvpaz.ApplicationMvp;
import com.z.mvp.base.presenter.IPresenter;
import com.z.mvp.base.view.MostBasicActivity;

public abstract class BaseActivity<P extends IPresenter>
        extends MostBasicActivity<ApplicationMvp, P> {

    @Override
    public ApplicationMvp peekApplication() {
        Application application = getApplication();
        return application instanceof ApplicationMvp ? (ApplicationMvp) application : null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

}
