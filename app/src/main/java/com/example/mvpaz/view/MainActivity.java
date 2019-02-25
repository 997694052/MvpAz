package com.example.mvpaz.view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.example.mvpaz.ApplicationMvp;
import com.example.mvpaz.R;
import com.example.mvpaz.presenter.MainPresenter;
import com.z.mvp.base.view.MostBasicActivity;

public class MainActivity extends MostBasicActivity<ApplicationMvp, MainPresenter> implements View.OnClickListener {

    private Button mBtShowMessage;

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        setViewListener();
        //ConstraintLayout layout = findViewById(R.id.layout_root);
        Fragment fragment = new FragmentOne();
        getSupportFragmentManager().beginTransaction().add(R.id.layout_root, fragment).commit();


    }

    private void findView() {
        mBtShowMessage = findViewById(R.id.bt_show_message);
    }

    private void setViewListener() {
        mBtShowMessage.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_show_message:
                showMessage("count = " + (mCount++));
                break;
            default:
        }
    }
}
