package com.atakandalkiran.bbnb.ui.campaign;

import android.os.Bundle;
import android.view.View;
import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;
import com.atakandalkiran.bbnb.databinding.FragmentCampaignBinding;

public class CampaignFragment extends BaseFragment {

    FragmentCampaignBinding binding;
    public CampaignFragment() {
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
        return R.layout.fragment_campaign;
    }
}