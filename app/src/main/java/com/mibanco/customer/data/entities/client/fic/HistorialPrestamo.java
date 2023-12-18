package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class HistorialPrestamo implements Serializable {

    private String nombreProducto;
    private String fechaDesembolso;
    private int montoDesembolsado;
    private String numeroPrestamo;
    private String estado;
    private String condicionPrestamo;
    private String fechaUltimoPago;
    private String saldoActual;
    private String tasaInteres;
    private int plazo;
    private int diasMoraActual;
    private int diasMoraMaxima;
    private int diasMoraPromedio;
    private String numeroCliente;

    public HistorialPrestamo(String nombreProducto, String fechaDesembolso, int montoDesembolsado, String numeroPrestamo, String estado, String condicionPrestamo, String fechaUltimoPago, String saldoActual, String tasaInteres, int plazo, int diasMoraActual, int diasMoraMaxima, int diasMoraPromedio, String numeroCliente) {
        this.setNombreProducto(nombreProducto);
        this.setFechaDesembolso(fechaDesembolso);
        this.setMontoDesembolsado(montoDesembolsado);
        this.setNumeroPrestamo(numeroPrestamo);
        this.setEstado(estado);
        this.setCondicionPrestamo(condicionPrestamo);
        this.setFechaUltimoPago(fechaUltimoPago);
        this.setSaldoActual(saldoActual);
        this.setTasaInteres(tasaInteres);
        this.setPlazo(plazo);
        this.setDiasMoraActual(diasMoraActual);
        this.setDiasMoraMaxima(diasMoraMaxima);
        this.setDiasMoraPromedio(diasMoraPromedio);
        this.setNumeroCliente(numeroCliente);
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(String fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public int getMontoDesembolsado() {
        return montoDesembolsado;
    }

    public void setMontoDesembolsado(int montoDesembolsado) {
        this.montoDesembolsado = montoDesembolsado;
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

    public String getCondicionPrestamo() {
        return condicionPrestamo;
    }

    public void setCondicionPrestamo(String condicionPrestamo) {
        this.condicionPrestamo = condicionPrestamo;
    }

    public String getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    public void setFechaUltimoPago(String fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    public String getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(String saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(String tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getDiasMoraActual() {
        return diasMoraActual;
    }

    public void setDiasMoraActual(int diasMoraActual) {
        this.diasMoraActual = diasMoraActual;
    }

    public int getDiasMoraMaxima() {
        return diasMoraMaxima;
    }

    public void setDiasMoraMaxima(int diasMoraMaxima) {
        this.diasMoraMaxima = diasMoraMaxima;
    }

    public int getDiasMoraPromedio() {
        return diasMoraPromedio;
    }

    public void setDiasMoraPromedio(int diasMoraPromedio) {
        this.diasMoraPromedio = diasMoraPromedio;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
}
