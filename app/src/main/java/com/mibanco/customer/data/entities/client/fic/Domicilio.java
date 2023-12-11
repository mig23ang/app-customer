package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Domicilio implements Serializable {

    private String numeroCliente;
    private String tipoVivienda;

    public Domicilio(String numeroCliente, String tipoVivienda) {
        this.setNumeroCliente(numeroCliente);
        this.setTipoVivienda(tipoVivienda);
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }
}
