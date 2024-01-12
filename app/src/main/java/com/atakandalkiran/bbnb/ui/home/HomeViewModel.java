package com.atakandalkiran.bbnb.ui.home;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.atakandalkiran.bbnb.db.CardDetailsModel;
import com.atakandalkiran.bbnb.db.UserDao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.Job;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<List<CardDetailsModel>> _cardProperties = new MutableLiveData<>();
    public LiveData<List<CardDetailsModel>> cardProperties = _cardProperties;

    private final UserDao userDao;
    private final Integer userId;

    public HomeViewModel(UserDao userDao, Integer userId) {
        this.userDao = userDao;
        this.userId = userId;
        loadCardDetails();
    }

    public LiveData<List<CardDetailsModel>> getCardPropertiesLiveData() {
        return cardProperties;
    }

    private void loadCardDetails() {
        // Assuming userDao.getCardDetailsByUserId returns LiveData<List<CardDetailsModel>>
        LiveData<List<CardDetailsModel>> cardDetailsLiveData = userDao.getCardDetailsByUserId(userId);

        // Observe the LiveData and update _cardProperties when the data changes
        cardDetailsLiveData.observeForever(cardDetails -> {
            _cardProperties.setValue(cardDetails);
        });
    }
}
