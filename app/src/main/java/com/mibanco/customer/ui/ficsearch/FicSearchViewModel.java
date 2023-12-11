package com.mibanco.customer.ui.ficsearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FicSearchViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FicSearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is report fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
