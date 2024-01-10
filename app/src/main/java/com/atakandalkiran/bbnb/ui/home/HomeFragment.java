package com.atakandalkiran.bbnb.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;
import com.atakandalkiran.bbnb.databinding.FragmentHomeBinding;
import com.atakandalkiran.bbnb.db.CardDetailsModel;
import com.atakandalkiran.bbnb.util.CardClickListener;

public class HomeFragment extends BaseFragment implements CardClickListener {

    FragmentHomeBinding binding;
    RecyclerView recyclerView;

    private HomeAdapter adapter;

    private HomeViewModel viewModel;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        adapter = new HomeAdapter(this);
        binding.creditCardsRecyclerView.setAdapter(adapter);

        return binding.getRoot();
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

    @Override
    public void onCardClick(View view, CardDetailsModel cardDetails) {
        NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_homeFragment_to_detailFragment);
    }

    @Override
    public void onCurrentChanged() {

    }
}