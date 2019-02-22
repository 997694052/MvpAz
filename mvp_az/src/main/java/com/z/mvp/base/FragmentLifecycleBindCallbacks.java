package com.z.mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import com.z.mvp.base.view.IView;

public class FragmentLifecycleBindCallbacks extends FragmentManager.FragmentLifecycleCallbacks {

    private static final String TAG = "AzDebug";

    @Override
    public void onFragmentViewCreated(@NonNull FragmentManager fm, @NonNull Fragment f, @NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onFragmentViewCreated(fm, f, v, savedInstanceState);
        if (f instanceof IView) {
            ((IView) f).peekPresenter().onViewCreated();
        }

        Log.i(TAG, "onFragmentViewCreated: ");
    }

    @Override
    public void onFragmentStarted(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentStarted(fm, f);
        Log.i(TAG, "onFragmentStarted: ");
    }

    @Override
    public void onFragmentResumed(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentResumed(fm, f);
        Log.i(TAG, "onFragmentResumed: ");
    }

    @Override
    public void onFragmentPaused(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentPaused(fm, f);
        Log.i(TAG, "onFragmentPaused: ");
    }

    @Override
    public void onFragmentStopped(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentStopped(fm, f);
        Log.i(TAG, "onFragmentStopped: ");
    }

    @Override
    public void onFragmentDestroyed(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentDestroyed(fm, f);
        Log.i(TAG, "onFragmentDestroyed: ");
    }

}
