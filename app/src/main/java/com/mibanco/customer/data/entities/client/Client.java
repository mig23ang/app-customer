package com.mibanco.customer.data.entities.client;

import java.io.Serializable;

public class Client implements Serializable {

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
    private String fechaUltimaActualizacion ;
    private String paisOrigen;


    public Client(String tipoDocumento, String numeroDocumento,
                  String nombreCompleto, String fechaUltimaActualizacion,
                  String paisOrigen){
        this.setTipoDocumento(tipoDocumento);
        this.setNumeroDocumento(numeroDocumento);
        this.setNombreCompleto(nombreCompleto);
        this.setFechaUltimaActualizacion(fechaUltimaActualizacion);
        this.setPaisOrigen(paisOrigen);
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
