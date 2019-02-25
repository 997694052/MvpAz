package com.example.mvpaz.presenter;

import android.support.annotation.NonNull;

import com.example.mvpaz.model.MainModel;
import com.example.mvpaz.view.activity.MainActivity;

public class MainPresenter extends BasePresenter<MainModel, MainActivity> {

    public MainPresenter(@NonNull MainActivity view) {
        super(view);
    }

    @Override
    public MainModel createModel() {
        return null;
    }

}
