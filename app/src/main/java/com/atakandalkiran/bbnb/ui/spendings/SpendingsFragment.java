package com.atakandalkiran.bbnb.ui.spendings;

import android.os.Bundle;
import android.view.View;
import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;
import com.atakandalkiran.bbnb.databinding.FragmentSpendingsBinding;

public class SpendingsFragment extends BaseFragment {

    FragmentSpendingsBinding binding;

    public SpendingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setBackground();
    }

    @Override
    protected void setupUI() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_spendings;
    }
}