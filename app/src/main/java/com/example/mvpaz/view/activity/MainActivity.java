package com.example.mvpaz.view.activity;

import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.mvpaz.R;
import com.example.mvpaz.presenter.MainPresenter;
import com.z.tools.az.DeviceTools;

public class MainActivity extends BaseActivity<MainPresenter> {

    private TextView mTvAndroidVersion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        mTvAndroidVersion.setText("android version :" + DeviceTools.getSystemModel());
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    private void findView() {
        mTvAndroidVersion = findViewById(R.id.tv_android_version);
    }


}
