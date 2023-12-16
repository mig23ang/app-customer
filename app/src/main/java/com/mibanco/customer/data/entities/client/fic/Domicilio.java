package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Domicilio implements Serializable {

    private String direccion;
    private String tipo;
    private String telefono1;
    private String telefono2;

    public Domicilio(String direccion, String tipo, String telefono1, String telefono2) {
        this.setDireccion(direccion);
        this.setTipo(tipo);
        this.setTelefono1(telefono1);
        this.setTelefono2(telefono2);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
}

