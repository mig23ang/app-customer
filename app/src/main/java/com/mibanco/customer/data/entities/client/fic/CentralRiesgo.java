package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class CentralRiesgo implements Serializable {

    private String persona ;

    private String resultadoConsultaReciente;
    private String vbConsulta;
    private String fechaConsultaReciente;


    public CentralRiesgo(String persona, String resultadoConsultaReciente, String vbConsulta, String fechaConsultaReciente) {
        this.setPersona(persona);
        this.setResultadoConsultaReciente(resultadoConsultaReciente);
        this.setVbConsulta(vbConsulta);
        this.setFechaConsultaReciente(fechaConsultaReciente);
    }


    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getResultadoConsultaReciente() {
        return resultadoConsultaReciente;
    }

    public void setResultadoConsultaReciente(String resultadoConsultaReciente) {
        this.resultadoConsultaReciente = resultadoConsultaReciente;
    }

    public String getVbConsulta() {
        return vbConsulta;
    }

    public void setVbConsulta(String vbConsulta) {
        this.vbConsulta = vbConsulta;
    }

    public String getFechaConsultaReciente() {
        return fechaConsultaReciente;
    }

    public void setFechaConsultaReciente(String fechaConsultaReciente) {
        this.fechaConsultaReciente = fechaConsultaReciente;
    }
}
