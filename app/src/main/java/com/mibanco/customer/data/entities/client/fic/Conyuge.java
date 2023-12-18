package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Conyuge implements Serializable {
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;


    public Conyuge(String tipoDocumento, String numeroDocumento, String nombre) {
        this.setTipoDocumento(tipoDocumento);
        this.setNumeroDocumento(numeroDocumento);
        this.setNombre(nombre);

    }


    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
