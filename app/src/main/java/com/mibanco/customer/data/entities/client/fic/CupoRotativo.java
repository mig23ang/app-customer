package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class CupoRotativo implements Serializable {

    private String estado;
    private String fechaDeVencimiento;
    private String montoCupoCredito;
    private String montoUtilizado;
    private String numeroCliente;
    private String numeroCupo;
    private String saldoDisponible;

    public CupoRotativo(String estado, String fechaDeVencimiento, String montoCupoCredito, String montoUtilizado, String numeroCliente, String numeroCupo, String saldoDisponible) {
        this.setEstado(estado);
        this.setFechaDeVencimiento(fechaDeVencimiento);
        this.setMontoCupoCredito(montoCupoCredito);
        this.setMontoUtilizado(montoUtilizado);
        this.setNumeroCliente(numeroCliente);
        this.setNumeroCupo(numeroCupo);
        this.setSaldoDisponible(saldoDisponible);
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public String getMontoCupoCredito() {
        return montoCupoCredito;
    }

    public void setMontoCupoCredito(String montoCupoCredito) {
        this.montoCupoCredito = montoCupoCredito;
    }

    public String getMontoUtilizado() {
        return montoUtilizado;
    }

    public void setMontoUtilizado(String montoUtilizado) {
        this.montoUtilizado = montoUtilizado;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNumeroCupo() {
        return numeroCupo;
    }

    public void setNumeroCupo(String numeroCupo) {
        this.numeroCupo = numeroCupo;
    }

    public String getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(String saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
