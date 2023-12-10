package com.atakandalkiran.bbnb.ui.home;

import android.os.Bundle;
import android.view.View;
import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;
import com.atakandalkiran.bbnb.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment {

    FragmentHomeBinding binding;

    public HomeFragment() {

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
        return  R.layout.fragment_home;
    }
}