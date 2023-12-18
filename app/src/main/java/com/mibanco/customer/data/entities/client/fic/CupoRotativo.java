package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class CupoRotativo implements Serializable {

    private String numeroCliente;
    private String numeroPrestamo;
    private String estado;
    private String montoCupo;
    private String montoUtilizado;
    private String saldoDisponible;
    private String fechaVencimiento;

    public CupoRotativo(String numeroCliente, String numeroPrestamo, String estado, String montoCupo, String montoUtilizado, String saldoDisponible, String fechaVencimiento) {
        this.setNumeroCliente(numeroCliente);
        this.setNumeroPrestamo(numeroPrestamo);
        this.setEstado(estado);
        this.setMontoCupo(montoCupo);
        this.setMontoUtilizado(montoUtilizado);
        this.setSaldoDisponible(saldoDisponible);
        this.setFechaVencimiento(fechaVencimiento);
    }


    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(String numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMontoCupo() {
        return montoCupo;
    }

    public void setMontoCupo(String montoCupo) {
        this.montoCupo = montoCupo;
    }

    public String getMontoUtilizado() {
        return montoUtilizado;
    }

    public void setMontoUtilizado(String montoUtilizado) {
        this.montoUtilizado = montoUtilizado;
    }

    public String getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(String saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
