package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class CentralRiesgo implements Serializable {


    private String numeroCliente;
    private String resultadoConsultaMasReciente;
    private Boolean vbVigenteParaSerConsultado;
    private String fechaConsultaMasReciente;


    public CentralRiesgo(String numeroCliente, String resultadoConsultaMasReciente, Boolean vbVigenteParaSerConsultado, String fechaConsultaMasReciente) {
        this.setNumeroCliente(numeroCliente);
        this.setResultadoConsultaMasReciente(resultadoConsultaMasReciente);
        this.setVbVigenteParaSerConsultado(vbVigenteParaSerConsultado);
        this.setFechaConsultaMasReciente(fechaConsultaMasReciente);
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getResultadoConsultaMasReciente() {
        return resultadoConsultaMasReciente;
    }

    public void setResultadoConsultaMasReciente(String resultadoConsultaMasReciente) {
        this.resultadoConsultaMasReciente = resultadoConsultaMasReciente;
    }

    public Boolean getVbVigenteParaSerConsultado() {
        return vbVigenteParaSerConsultado;
    }

    public void setVbVigenteParaSerConsultado(Boolean vbVigenteParaSerConsultado) {
        this.vbVigenteParaSerConsultado = vbVigenteParaSerConsultado;
    }

    public String getFechaConsultaMasReciente() {
        return fechaConsultaMasReciente;
    }

    public void setFechaConsultaMasReciente(String fechaConsultaMasReciente) {
        this.fechaConsultaMasReciente = fechaConsultaMasReciente;
    }
}
