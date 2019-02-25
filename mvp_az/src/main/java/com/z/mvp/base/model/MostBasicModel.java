package com.z.mvp.base.model;

import android.app.Application;

/**
 * 一个Model的基类.
 * 只是完成了一些常用的方法.应用的model完全可以不从本类派生.不针对model做任何的检查.
 *
 * @param <A> 应用的application
 *            <p>
 *            Created by Az
 *            on 2019/2/25.
 */
public class MostBasicModel<A extends Application> {

    protected A mApplication;

    public MostBasicModel(A application) {
        this.mApplication = application;
    }

}
