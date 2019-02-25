package com.example.mvpaz.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.mvpaz.ApplicationMvp;
import com.example.mvpaz.view.FragmentOne;
import com.z.mvp.base.presenter.MostBasicPresenter;

public class FragmentOnePresenter
        extends MostBasicPresenter<String, FragmentOne, ApplicationMvp> {

    private static final String TAG = "AzDebug";

    public FragmentOnePresenter(@NonNull FragmentOne view) {
        super(view);
    }

    @Override
    public String createModel() {
        return null;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        Log.i(TAG, "onViewCreated: FragmentOnePresenter");
    }

    @Override
    public void onViewStarted() {
        super.onViewStarted();
        Log.i(TAG, "onViewStarted: FragmentOnePresenter");
    }

    @Override
    public void onViewResumed() {
        super.onViewResumed();
        Log.i(TAG, "onViewResumed: FragmentOnePresenter");
    }

    @Override
    public void onViewPaused() {
        super.onViewPaused();
        Log.i(TAG, "onViewPaused: FragmentOnePresenter");
    }

    @Override
    public void onViewStopped() {
        super.onViewStopped();
        Log.i(TAG, "onViewStopped: FragmentOnePresenter");
    }

    @Override
    public void onViewDestroyed() {
        super.onViewDestroyed();
        Log.i(TAG, "onViewDestroyed: FragmentOnePresenter");
    }
}
