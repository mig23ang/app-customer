package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Pasivo implements Serializable {

    private String numeroCliente;
    private String numeroProducto;
    private String tipoProducto;
    private String detalleProducto;
    private String estadoPasivo;
    private String fechaApertura;
    private String fechaCierre;
    private String capital;
    private String intereses;
    private String otros;
    private String saldoTotal;

    public Pasivo(String numeroCliente, String numeroProducto, String tipoProducto, String detalleProducto, String estadoPasivo, String fechaApertura, String fechaCierre, String capital, String intereses, String otros, String saldoTotal) {
        this.setNumeroCliente(numeroCliente);
        this.setNumeroProducto(numeroProducto);
        this.setTipoProducto(tipoProducto);
        this.setDetalleProducto(detalleProducto);
        this.setEstadoPasivo(estadoPasivo);
        this.setFechaApertura(fechaApertura);
        this.setFechaCierre(fechaCierre);
        this.setCapital(capital);
        this.setIntereses(intereses);
        this.setOtros(otros);
        this.setSaldoTotal(saldoTotal);
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

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public String getEstadoPasivo() {
        return estadoPasivo;
    }

    public void setEstadoPasivo(String estadoPasivo) {
        this.estadoPasivo = estadoPasivo;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(String saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
}
