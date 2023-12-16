package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Negocio implements Serializable {

    private String direccion;
    private String actividad;
    private String telefono1;

    public Negocio(String direccion, String actividad, String telefono1) {
        this.setDireccion(direccion);
        this.setActividad(actividad);
        this.setTelefono1(telefono1);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }
}
