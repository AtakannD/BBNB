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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;
import com.atakandalkiran.bbnb.databinding.FragmentHomeBinding;
import com.atakandalkiran.bbnb.db.AppDatabase;
import com.atakandalkiran.bbnb.db.CardDetailsModel;
import com.atakandalkiran.bbnb.db.UserDao;
import com.atakandalkiran.bbnb.util.CardClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class HomeFragment extends BaseFragment implements CardClickListener {

    FragmentHomeBinding binding;
    RecyclerView recyclerView;

    private HomeAdapter adapter;

    private HomeViewModel viewModel;
    FloatingActionButton cardAdderButton;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);

        cardAdderButton = binding.addingCardButton;

        binding.setLifecycleOwner(getViewLifecycleOwner());

        adapter = new HomeAdapter(this);
        binding.creditCardsRecyclerView.setAdapter(adapter);
        binding.creditCardsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        if (getArguments() != null) {
            int userId = getArguments().getInt("userId", 0);
            UserDao userDao = AppDatabase.getDbInstance(requireContext()).userdao();
            viewModel = new ViewModelProvider(this, new HomeViewModelFactory(requireContext(), userId, userDao))
                    .get(HomeViewModel.class);
        }

        if (viewModel != null && viewModel.getCardPropertiesLiveData() != null) {
            viewModel.getCardPropertiesLiveData().observe(getViewLifecycleOwner(), cardDetailsList -> {
                if (cardDetailsList.isEmpty()) {
                    binding.cardViewRV.setVisibility(View.INVISIBLE);
                } else {
                    binding.cardViewRV.setVisibility(View.VISIBLE);
                    adapter.submitList(cardDetailsList);
                }
            });
        }

        cardAdderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getArguments() != null) {
                    int userId = getArguments().getInt("userId", 0);
                    Bundle args = new Bundle();
                    args.putInt("userId", userId);
                    NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_homeFragment_to_addingCardFragment, args);
                }
            }
        });

        return binding.getRoot();
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

    @Override
    public void onCardClick(View view, CardDetailsModel cardDetails) {
        NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_homeFragment_to_detailFragment);
    }

    @Override
    public void onCurrentChanged() {

    }
}