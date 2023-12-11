package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class DomicilioEmpresa implements Serializable {

    private String numeroCliente;
    private String dirrecion;
    private String telefono1;
    private String telefono2;
    private String tipoActividadCIIU;
    private String tipoLocal;

    public DomicilioEmpresa(String numeroCliente, String dirrecion, String telefono1, String telefono2, String tipoActividadCIIU, String tipoLocal) {
        this.setNumeroCliente(numeroCliente);
        this.setDirrecion(dirrecion);
        this.setTelefono1(telefono1);
        this.setTelefono2(telefono2);
        this.setTipoActividadCIIU(tipoActividadCIIU);
        this.setTipoLocal(tipoLocal);
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
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

    public String getTipoActividadCIIU() {
        return tipoActividadCIIU;
    }

    public void setTipoActividadCIIU(String tipoActividadCIIU) {
        this.tipoActividadCIIU = tipoActividadCIIU;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }
}
