package com.mibanco.customer.data.entities.client.fic;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DataClients implements Serializable {

    @SerializedName("data")
    private List<Client> datos;

    @SerializedName("msg")
    private ApiMessage apiMessage;


    public List<Client> getDatos() {
        return datos;
    }

    public void setDatos(List<Client> datos) {
        this.datos = datos;
    }

    public ApiMessage getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessage apiMessage) {
        this.apiMessage = apiMessage;
    }
}
