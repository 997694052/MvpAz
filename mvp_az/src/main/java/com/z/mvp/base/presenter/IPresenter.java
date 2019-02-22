package com.z.mvp.base.presenter;

/**
 * 这个接口定义了Presenter的基本行为.应用的presenter需要实现这个接口.
 *
 * @param <M> presenter持有的Model类型，具体类型在IPresenter的最终实现类中确定.
 *            <p>
 *            Created by Az
 *            on 2019/2/22.
 */
public interface IPresenter<M> {

    M createModel();        //创建model

    void onViewCreate();    //与之绑定的View创建

    void onViewStart();     //与之绑定的View可见或部分可见

    void onViewResume();    //与之绑定的View激活状态,可以交互

    void onViewPause();     //与之绑定的View暂停状态,停止交互

    void onViewStop();      //与之绑定的View停止状态,完全不可见

    void onViewDestroy();   //与之绑定的View销毁,应该解除各种引用

}
