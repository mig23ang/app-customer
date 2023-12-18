package com.mibanco.customer.data.entities.client.fic.datas;

import com.google.gson.annotations.SerializedName;
import com.mibanco.customer.data.entities.client.fic.HistorialPrestamo;

import java.io.Serializable;
import java.util.List;

public class DataHistorialPrestamo implements Serializable {
    @SerializedName("data")
    private List<HistorialPrestamo> datos;


    public DataHistorialPrestamo(List<HistorialPrestamo> datos) {
        this.setDatos(datos);
    }

    public List<HistorialPrestamo> getDatos() {
        return datos;
    }

    public void setDatos(List<HistorialPrestamo> datos) {
        this.datos = datos;
    }
}
