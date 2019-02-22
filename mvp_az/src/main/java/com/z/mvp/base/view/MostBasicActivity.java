package com.z.mvp.base.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.z.mvp.base.presenter.IPresenter;

/**
 * 在框架层对IView进行了Activity的基本实现.应用的Activity只需要实现{@link IView}和{@link IActivity}即可,
 * 继承本类是可选的.
 * 本类默认实现IActivity,且返回false,即该activity中没有需要绑定生命周期的fragment.
 *
 * @param <A> 应用的Application类型,具体类型在应用中确定.
 * @param <P> view持有的presenter类型,具体类型在IView的最终实现类中确定.
 *            <p>
 *            Created by Az
 *            on 2019/2/22.
 */
public abstract class MostBasicActivity<A extends Application, P extends IPresenter>
        extends AppCompatActivity
        implements IView<A, P>, IActivity {

    private P mPresenter;
    protected Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.mPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }

    @Override
    public P peekPresenter() {
        return mPresenter;
    }

    @Override
    public boolean hasFragment() {
        return false;
    }

    @Override
    public void showMessage(String message) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }

}
