package com.atakandalkiran.bbnb.ui.campaign;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atakandalkiran.bbnb.R;

public class CampaignFragment extends Fragment {

    public CampaignFragment() {
        // Required empty public constructor
    }

    public static CampaignFragment newInstance(String param1, String param2) {
        CampaignFragment fragment = new CampaignFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_campaign, container, false);
    }
}