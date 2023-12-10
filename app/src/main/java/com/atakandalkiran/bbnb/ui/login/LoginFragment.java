package com.atakandalkiran.bbnb.ui.login;

import android.os.Bundle;
import android.view.View;
import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;

public class LoginFragment extends BaseFragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setupUI() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setBackground();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_login;
    }
}