package com.mibanco.customer.data.entities.client.fic.datas;

import com.google.gson.annotations.SerializedName;
import com.mibanco.customer.data.entities.client.fic.Pasivo;

import java.io.Serializable;
import java.util.List;

public class DataPasivos implements Serializable {

    @SerializedName("data")
    private List<Pasivo> pasivos;

    public DataPasivos(List<Pasivo> pasivos) {
        this.setPasivos(pasivos);
    }


    public List<Pasivo> getPasivos() {
        return pasivos;
    }

    public void setPasivos(List<Pasivo> pasivos) {
        this.pasivos = pasivos;
    }
}
