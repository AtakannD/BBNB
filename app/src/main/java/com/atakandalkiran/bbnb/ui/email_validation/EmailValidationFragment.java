package com.atakandalkiran.bbnb.ui.email_validation;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;
import com.atakandalkiran.bbnb.databinding.FragmentEmailValidationBinding;

public class EmailValidationFragment extends BaseFragment {
    FragmentEmailValidationBinding binding;
    Button button;

    public EmailValidationFragment() {
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, getLayoutResId(), container, false);

        button = binding.validationButton;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(EmailValidationFragment.this).navigate(R.id.action_emailValidationFragment_to_forgottenPasswordFragment);
            }
        });
        return binding.getRoot();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_email_validation;
    }
}