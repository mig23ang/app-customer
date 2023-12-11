package com.mibanco.customer.ui.ficsearch.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DatosBasicosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DatosBasicosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is report fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
