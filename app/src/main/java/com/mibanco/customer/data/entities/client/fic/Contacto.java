package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Contacto  implements Serializable {
    private String numeroCliente;
    private String fecha;
    private String tipo;
    private String resultadoComentarios;

    public Contacto(String numeroCliente, String fecha, String tipo, String resultadoComentarios) {
        this.setNumeroCliente(numeroCliente);
        this.setFecha(fecha);
        this.setTipoContacto(tipo);
        this.setResultadoComentarios(resultadoComentarios);
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

    public String getTipoContacto() {
        return tipo;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipo = tipoContacto;
    }

    public String getResultadoComentarios() {
        return resultadoComentarios;
    }

    public void setResultadoComentarios(String resultadoComentarios) {
        this.resultadoComentarios = resultadoComentarios;
    }
}
