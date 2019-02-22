package com.example.mvpaz.presenter;

import android.util.Log;

import com.example.mvpaz.ApplicationMvp;
import com.example.mvpaz.view.MainActivity;
import com.z.mvp.base.presenter.MostBasicPresenter;

public class MainPresenter extends MostBasicPresenter<String, MainActivity, ApplicationMvp> {

    private static final String TAG = "AzDebug";

    public MainPresenter(MainActivity view) {
        super(view);
    }

    @Override
    public String createModel() {
        return null;
    }

    @Override
    public void onViewCreate() {
        super.onViewCreate();
        Log.i(TAG, "onViewCreate: MainActivityPresenter");
    }

    @Override
    public void onViewStart() {
        super.onViewStart();
        Log.i(TAG, "onViewStart: MainActivityPresenter");
    }

    @Override
    public void onViewResume() {
        super.onViewResume();
        Log.i(TAG, "onViewResume: MainActivityPresenter");
    }

    @Override
    public void onViewPause() {
        super.onViewPause();
        Log.i(TAG, "onViewPause: MainActivityPresenter");
    }

    @Override
    public void onViewStop() {
        super.onViewStop();
        Log.i(TAG, "onViewStop: MainActivityPresenter");
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
        Log.i(TAG, "onViewDestroy: MainActivityPresenter");
    }

}
