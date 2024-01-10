package com.atakandalkiran.bbnb.util;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.atakandalkiran.bbnb.databinding.LayoutRecyclerviewCreditCardsBinding;
import com.atakandalkiran.bbnb.db.CardDetailsModel;

public class CardItemViewHolder extends RecyclerView.ViewHolder {

    private final LayoutRecyclerviewCreditCardsBinding binding;

    public CardItemViewHolder(LayoutRecyclerviewCreditCardsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(CardClickListener clickListener, CardDetailsModel cardDetails) {
        binding.setCard(cardDetails);
        binding.setClickListener(clickListener);
        binding.executePendingBindings();
    }

    public static CardItemViewHolder from(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutRecyclerviewCreditCardsBinding binding = LayoutRecyclerviewCreditCardsBinding.inflate(layoutInflater, parent, false);
        return new CardItemViewHolder(binding);
    }
}

