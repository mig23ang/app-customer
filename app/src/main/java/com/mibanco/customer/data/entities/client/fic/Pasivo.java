package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Pasivo implements Serializable {

    private String numeroCliente;
    private String numeroProducto;
    private String estado;
    private int capital;
    private String tipoProducto;
    private String detalleTipoProducto;
    private int intereses;
    private int otros;
    private int saldoTotal;
    private String fechaApertura;
    private String fechaCierre;


    public Pasivo(String numeroCliente, String numeroProducto, String estado, int capital, String tipoProducto, String detalleTipoProducto, int intereses, int otros, int saldoTotal, String fechaApertura, String fechaCierre) {
        this.setNumeroCliente(numeroCliente);
        this.setNumeroProducto(numeroProducto);
        this.setEstado(estado);
        this.setCapital(capital);
        this.setTipoProducto(tipoProducto);
        this.setDetalleTipoProducto(detalleTipoProducto);
        this.setIntereses(intereses);
        this.setOtros(otros);
        this.setSaldoTotal(saldoTotal);
        this.setFechaApertura(fechaApertura);
        this.setFechaCierre(fechaCierre);
    }


    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNumeroProducto() {
        return numeroProducto;
    }

    public void setNumeroProducto(String numeroProducto) {
        this.numeroProducto = numeroProducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDetalleTipoProducto() {
        return detalleTipoProducto;
    }

    public void setDetalleTipoProducto(String detalleTipoProducto) {
        this.detalleTipoProducto = detalleTipoProducto;
    }

    public int getIntereses() {
        return intereses;
    }

    public void setIntereses(int intereses) {
        this.intereses = intereses;
    }

    public int getOtros() {
        return otros;
    }

    public void setOtros(int otros) {
        this.otros = otros;
    }

    public int getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(int saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
