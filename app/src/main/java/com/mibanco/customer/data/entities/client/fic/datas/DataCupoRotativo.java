package com.mibanco.customer.data.entities.client.fic.datas;

import com.google.gson.annotations.SerializedName;
import com.mibanco.customer.data.entities.client.fic.CupoRotativo;

import java.io.Serializable;
import java.util.List;

public class DataCupoRotativo implements Serializable {

    @SerializedName("data")
    private List<CupoRotativo> datos;

    public DataCupoRotativo(List<CupoRotativo> datos) {
        this.setDatos(datos);
    }


    public List<CupoRotativo> getDatos() {
        return datos;
    }

    public void setDatos(List<CupoRotativo> datos) {
        this.datos = datos;
    }
}
