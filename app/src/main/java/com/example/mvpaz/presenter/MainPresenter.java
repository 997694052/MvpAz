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
    public void onViewCreated() {
        super.onViewCreated();
        Log.i(TAG, "onViewCreated: MainActivityPresenter");
    }

    @Override
    public void onViewStarted() {
        super.onViewStarted();
        Log.i(TAG, "onViewStarted: MainActivityPresenter");
    }

    @Override
    public void onViewResumed() {
        super.onViewResumed();
        Log.i(TAG, "onViewResumed: MainActivityPresenter");
    }

    @Override
    public void onViewPaused() {
        super.onViewPaused();
        Log.i(TAG, "onViewPaused: MainActivityPresenter");
    }

    @Override
    public void onViewStopped() {
        super.onViewStopped();
        Log.i(TAG, "onViewStopped: MainActivityPresenter");
    }

    @Override
    public void onViewDestroyed() {
        super.onViewDestroyed();
        Log.i(TAG, "onViewDestroyed: MainActivityPresenter");
    }

}
