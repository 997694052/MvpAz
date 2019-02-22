package com.z.mvp.base.view;

import android.app.Application;

import com.z.mvp.base.presenter.IPresenter;


/**
 * 这个接口定义了View的基本行为.应用的view需要实现这个接口.
 *
 * @param <A> 应用的Application类型，具体类型在应用中确定
 * @param <P> view持有的presenter类型，具体类型在view的最终实现类中确定
 *            <p>
 *            Created by Az
 *            on 2019/2/19.
 */
public interface IView<A extends Application, P extends IPresenter> {

    P createPresenter();   //创建presenter

    P peekPresenter();     //获取presenter

    A peekApplication();                //获取application

    void showProgress();                //显示加载进度

    void dismissProgress();             //隐藏加载进度

    void showMessage(String message);   //显示一条消息

}
