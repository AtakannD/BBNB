package com.atakandalkiran.bbnb.ui.email_validation;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atakandalkiran.bbnb.R;

public class EmailValidationFragment extends Fragment {

    private EmailValidationViewModel mViewModel;

    public static EmailValidationFragment newInstance() {
        return new EmailValidationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_email_validation, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EmailValidationViewModel.class);
        // TODO: Use the ViewModel
    }

}