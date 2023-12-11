package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Pqr implements Serializable {

    private String numeroCliente;
    private String fecha;
    private String numeroPQR;
    private String motivo;
    private String resultadoPQR;
    private String comentario;


    public Pqr(String numeroCliente, String fecha, String numeroPQR, String motivo, String resultadoPQR, String comentario) {
        this.setNumeroCliente(numeroCliente);
        this.setFecha(fecha);
        this.setNumeroPQR(numeroPQR);
        this.setMotivo(motivo);
        this.setResultadoPQR(resultadoPQR);
        this.setComentario(comentario);
    }


    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumeroPQR() {
        return numeroPQR;
    }

    public void setNumeroPQR(String numeroPQR) {
        this.numeroPQR = numeroPQR;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getResultadoPQR() {
        return resultadoPQR;
    }

    public void setResultadoPQR(String resultadoPQR) {
        this.resultadoPQR = resultadoPQR;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
