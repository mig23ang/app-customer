package com.mibanco.customer.ui.ficsearch.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OfertaAlertaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OfertaAlertaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is report fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
