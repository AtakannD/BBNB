package com.atakandalkiran.bbnb.ui.forgotten_password;

import android.os.Bundle;
import android.view.View;
import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;

public class ForgottenPasswordFragment extends BaseFragment {


    public ForgottenPasswordFragment() {
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
        return R.layout.fragment_forgotten_password;
    }
}