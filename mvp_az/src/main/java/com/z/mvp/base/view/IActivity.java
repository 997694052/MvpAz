package com.z.mvp.base.view;

/**
 * 如果activity内有需要绑定生命周期的fragment,则需要实现此接口.
 * <p>
 * Created by Az
 * on 2019/2//22.
 */
public interface IActivity {

    boolean hasFragment();  //如果activity内有需要绑定生命周期的fragment,返回true;否则返回false

}
