package com.atakandalkiran.bbnb.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.atakandalkiran.bbnb.db.CardDetailsModel;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<CardDetailsModel>> cardPropertiesLiveData = new MutableLiveData<>();

    public LiveData<List<CardDetailsModel>> getCardPropertiesLiveData() {
        return cardPropertiesLiveData;
    }

    public void setCardProperties(List<CardDetailsModel> cardProperties) {
        cardPropertiesLiveData.setValue(cardProperties);
    }
}
