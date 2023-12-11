package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class ReporteCentralRiesgoType implements Serializable {

    private String antiguedadUbicacion;
    private String consultaDetallada;
    private String estadoDocumento;
    private String fechaConsultaMasReciente;
    private String genero;
    private String historicoEndeudamiento;
    private String lugarExpedicion;
    private String numeroDocumento;
    private String rangoEdad;
    private String resultadoConsultaMasReciente;
    private Boolean tieneRUT;
    private String tipoDocumento;
    private String tipoRelacion;
    private String tipoReporte;
    private String vbVigenteParaSerConsultado;
    private String digitoVerificacion;

    public ReporteCentralRiesgoType(String antiguedadUbicacion, String consultaDetallada, String estadoDocumento, String fechaConsultaMasReciente, String genero, String historicoEndeudamiento, String lugarExpedicion, String numeroDocumento, String rangoEdad, String resultadoConsultaMasReciente, Boolean tieneRUT, String tipoDocumento, String tipoRelacion, String tipoReporte, String vbVigenteParaSerConsultado, String digitoVerificacion) {
        this.setAntiguedadUbicacion(antiguedadUbicacion);
        this.setConsultaDetallada(consultaDetallada);
        this.setEstadoDocumento(estadoDocumento);
        this.setFechaConsultaMasReciente(fechaConsultaMasReciente);
        this.setGenero(genero);
        this.setHistoricoEndeudamiento(historicoEndeudamiento);
        this.setLugarExpedicion(lugarExpedicion);
        this.setNumeroDocumento(numeroDocumento);
        this.setRangoEdad(rangoEdad);
        this.setResultadoConsultaMasReciente(resultadoConsultaMasReciente);
        this.setTieneRUT(tieneRUT);
        this.setTipoDocumento(tipoDocumento);
        this.setTipoRelacion(tipoRelacion);
        this.setTipoReporte(tipoReporte);
        this.setVbVigenteParaSerConsultado(vbVigenteParaSerConsultado);
        this.setDigitoVerificacion(digitoVerificacion);
    }


    public String getAntiguedadUbicacion() {
        return antiguedadUbicacion;
    }

    public void setAntiguedadUbicacion(String antiguedadUbicacion) {
        this.antiguedadUbicacion = antiguedadUbicacion;
    }

    public String getConsultaDetallada() {
        return consultaDetallada;
    }

    public void setConsultaDetallada(String consultaDetallada) {
        this.consultaDetallada = consultaDetallada;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public String getFechaConsultaMasReciente() {
        return fechaConsultaMasReciente;
    }

    public void setFechaConsultaMasReciente(String fechaConsultaMasReciente) {
        this.fechaConsultaMasReciente = fechaConsultaMasReciente;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHistoricoEndeudamiento() {
        return historicoEndeudamiento;
    }

    public void setHistoricoEndeudamiento(String historicoEndeudamiento) {
        this.historicoEndeudamiento = historicoEndeudamiento;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public String getResultadoConsultaMasReciente() {
        return resultadoConsultaMasReciente;
    }

    public void setResultadoConsultaMasReciente(String resultadoConsultaMasReciente) {
        this.resultadoConsultaMasReciente = resultadoConsultaMasReciente;
    }

    public Boolean getTieneRUT() {
        return tieneRUT;
    }

    public void setTieneRUT(Boolean tieneRUT) {
        this.tieneRUT = tieneRUT;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getVbVigenteParaSerConsultado() {
        return vbVigenteParaSerConsultado;
    }

    public void setVbVigenteParaSerConsultado(String vbVigenteParaSerConsultado) {
        this.vbVigenteParaSerConsultado = vbVigenteParaSerConsultado;
    }

    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }
}
