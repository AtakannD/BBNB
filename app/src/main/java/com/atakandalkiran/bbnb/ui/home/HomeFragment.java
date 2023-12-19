package com.atakandalkiran.bbnb.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;
import com.atakandalkiran.bbnb.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment {

    FragmentHomeBinding binding;
    RecyclerView recyclerView;

    private HomeViewModel viewModel;

    public HomeFragment() {

    }

    @Override
    protected void setupUI() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setBackground();
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    protected int getLayoutResId() {
        return  R.layout.fragment_home;
    }
}