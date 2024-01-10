package com.atakandalkiran.bbnb.ui.home;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.atakandalkiran.bbnb.db.CardDetailsModel;
import com.atakandalkiran.bbnb.util.CardClickListener;
import com.atakandalkiran.bbnb.util.CardItemViewHolder;

import java.util.List;

public class HomeAdapter extends ListAdapter<CardDetailsModel, CardItemViewHolder> {

    private final CardClickListener clickListener;

    public HomeAdapter(CardClickListener clickListener) {
        super(new CountriesItemDiffCallback());
        this.clickListener = clickListener;
    }

    @Override
    public CardItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CardItemViewHolder.from(parent);
    }

    @Override
    public void onCurrentListChanged(List<CardDetailsModel> previousList, List<CardDetailsModel> currentList) {
        super.onCurrentListChanged(previousList, currentList);
        clickListener.onCurrentChanged();
    }

    @Override
    public void onBindViewHolder(CardItemViewHolder holder, int position) {
        holder.bind(clickListener, getItem(position));
    }
}

class CountriesItemDiffCallback extends DiffUtil.ItemCallback<CardDetailsModel> {
    @Override
    public boolean areItemsTheSame(CardDetailsModel oldItem, CardDetailsModel newItem) {
        return oldItem.getCardTitle().equals(newItem.getCardTitle());
    }

    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(CardDetailsModel oldItem, CardDetailsModel newItem) {
        return oldItem.equals(newItem);
    }
}
