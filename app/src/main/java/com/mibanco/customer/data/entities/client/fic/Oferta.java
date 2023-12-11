package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Oferta implements Serializable {

    private String numeroCliente;
    private String numeroOferta;
    private String tipoLead;
    private String tipoOferta;
    private String monto;
    private String plazo;
    private String tipoDeLiga;
    private String condicionGarantia;

    public Oferta(String numeroCliente, String numeroOferta, String tipoLead, String tipoOferta, String monto, String plazo, String tipoDeLiga, String condicionGarantia) {
        this.setNumeroCliente(numeroCliente);
        this.setNumeroOferta(numeroOferta);
        this.setTipoLead(tipoLead);
        this.setTipoOferta(tipoOferta);
        this.setMonto(monto);
        this.setPlazo(plazo);
        this.setTipoDeLiga(tipoDeLiga);
        this.setCondicionGarantia(condicionGarantia);
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNumeroOferta() {
        return numeroOferta;
    }

    public void setNumeroOferta(String numeroOferta) {
        this.numeroOferta = numeroOferta;
    }

    public String getTipoLead() {
        return tipoLead;
    }

    public void setTipoLead(String tipoLead) {
        this.tipoLead = tipoLead;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getTipoDeLiga() {
        return tipoDeLiga;
    }

    public void setTipoDeLiga(String tipoDeLiga) {
        this.tipoDeLiga = tipoDeLiga;
    }

    public String getCondicionGarantia() {
        return condicionGarantia;
    }

    public void setCondicionGarantia(String condicionGarantia) {
        this.condicionGarantia = condicionGarantia;
    }
}
