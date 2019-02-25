package com.example.mvpaz.view.activity;

import com.example.mvpaz.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> {

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

}
