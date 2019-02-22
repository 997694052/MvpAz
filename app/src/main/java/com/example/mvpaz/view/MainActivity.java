package com.example.mvpaz.view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.Layout;

import com.example.mvpaz.ApplicationMvp;
import com.example.mvpaz.R;
import com.example.mvpaz.presenter.MainPresenter;
import com.z.mvp.base.view.MostBasicActivity;

public class MainActivity extends MostBasicActivity<ApplicationMvp, MainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.layout_root);

        Fragment fragment = new FragmentOne();
        getSupportFragmentManager().beginTransaction().add(R.id.layout_root,fragment).commit();


    }

    @Override
    public boolean hasFragment() {
        return true;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
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
