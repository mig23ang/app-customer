package com.mibanco.customer.ui.ficsearch.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CentralesRiesgoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CentralesRiesgoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is report fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
