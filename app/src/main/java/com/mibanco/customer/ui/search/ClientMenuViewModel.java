package com.mibanco.customer.ui.search;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;

public class ClientMenuViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private final MutableLiveData<InformacionPrincipal> informacionPrincipal = new MutableLiveData<>();

    public void setInformacionPrincipal(InformacionPrincipal info) {
        informacionPrincipal.postValue(info);
    }

    public LiveData<InformacionPrincipal> getInformacionPrincipal() {
        return informacionPrincipal;
    }

    public ClientMenuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is report fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
