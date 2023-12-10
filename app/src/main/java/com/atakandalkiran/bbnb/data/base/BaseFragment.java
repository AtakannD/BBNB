package com.atakandalkiran.bbnb.data.base;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.databinding.FragmentBaseBinding;

public abstract class BaseFragment extends Fragment {

    ViewDataBinding binding;
    protected abstract void setupUI();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, getLayoutResId(), container, false);

        setupUI();

        return binding.getRoot();
    }

    protected abstract int getLayoutResId();

    protected void setBackground() {
        int colorTop = ContextCompat.getColor(requireContext(), R.color.dusty_bluish_teal);
        int colorBottom = ContextCompat.getColor(requireContext(), R.color.grayish_dusty_rose);

        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{colorTop, colorBottom});

        View view = requireView();
        if (view instanceof ConstraintLayout) {
            ((ConstraintLayout) view).setBackground(gradientDrawable);
        }
    }
}
