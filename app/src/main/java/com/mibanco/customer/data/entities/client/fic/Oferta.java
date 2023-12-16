package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Oferta implements Serializable {


    private int id;
    private String categoria;
    private String opcion;
    private String tipo;
    private String fechaInicial;
    private String fechaFinal;
    private int monto;
    private int plazo;
    private String tipoLiga;
    private String condicionGarantia;


    public Oferta(int id, String categoria, String opcion, String tipo, String fechaInicial, String fechaFinal, int monto, int plazo, String tipoLiga, String condicionGarantia) {
        this.setId(id);
        this.setCategoria(categoria);
        this.setOpcion(opcion);
        this.setTipo(tipo);
        this.setFechaInicial(fechaInicial);
        this.setFechaFinal(fechaFinal);
        this.setMonto(monto);
        this.setPlazo(plazo);
        this.setTipoLiga(tipoLiga);
        this.setCondicionGarantia(condicionGarantia);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getTipoLiga() {
        return tipoLiga;
    }

    public void setTipoLiga(String tipoLiga) {
        this.tipoLiga = tipoLiga;
    }

    public String getCondicionGarantia() {
        return condicionGarantia;
    }

    public void setCondicionGarantia(String condicionGarantia) {
        this.condicionGarantia = condicionGarantia;
    }
}
