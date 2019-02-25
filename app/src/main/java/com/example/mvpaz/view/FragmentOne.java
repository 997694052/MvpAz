package com.example.mvpaz.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvpaz.ApplicationMvp;
import com.example.mvpaz.R;
import com.example.mvpaz.presenter.FragmentOnePresenter;
import com.z.mvp.base.view.MostBasicFragment;

public class FragmentOne extends MostBasicFragment<ApplicationMvp, FragmentOnePresenter> {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public FragmentOnePresenter createPresenter() {
        return new FragmentOnePresenter(this);
    }

    @Override
    public ApplicationMvp peekApplication() {
        return null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
