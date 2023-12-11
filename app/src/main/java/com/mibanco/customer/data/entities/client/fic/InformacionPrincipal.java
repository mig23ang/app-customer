package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class InformacionPrincipal implements Serializable {
    private String estadoCivil;
    private String funcionarioUltimaActualizacion;
    private String numeroDocumentoRepresentanteLegal;
    private String nombreRepresentanteLegal;
    private String razonSocial;
    private String seRequiereActualizacion;
    private String tipoDocumentoRepresentanteLegal;
    private String totalActivos;
    private String ultimaFechaActualizacion;

    public InformacionPrincipal(String estadoCivil, String funcionarioUltimaActualizacion, String numeroDocumentoRepresentanteLegal, String nombreRepresentanteLegal, String razonSocial, String seRequiereActualizacion, String tipoDocumentoRepresentanteLegal, String totalActivos, String ultimaFechaActualizacion) {
        this.setEstadoCivil(estadoCivil);
        this.setFuncionarioUltimaActualizacion(funcionarioUltimaActualizacion);
        this.setNumeroDocumentoRepresentanteLegal(numeroDocumentoRepresentanteLegal);
        this.setNombreRepresentanteLegal(nombreRepresentanteLegal);
        this.setRazonSocial(razonSocial);
        this.setSeRequiereActualizacion(seRequiereActualizacion);
        this.setTipoDocumentoRepresentanteLegal(tipoDocumentoRepresentanteLegal);
        this.setTotalActivos(totalActivos);
        this.setUltimaFechaActualizacion(ultimaFechaActualizacion);
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFuncionarioUltimaActualizacion() {
        return funcionarioUltimaActualizacion;
    }

    public void setFuncionarioUltimaActualizacion(String funcionarioUltimaActualizacion) {
        this.funcionarioUltimaActualizacion = funcionarioUltimaActualizacion;
    }

    public String getNumeroDocumentoRepresentanteLegal() {
        return numeroDocumentoRepresentanteLegal;
    }

    public void setNumeroDocumentoRepresentanteLegal(String numeroDocumentoRepresentanteLegal) {
        this.numeroDocumentoRepresentanteLegal = numeroDocumentoRepresentanteLegal;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSeRequiereActualizacion() {
        return seRequiereActualizacion;
    }

    public void setSeRequiereActualizacion(String seRequiereActualizacion) {
        this.seRequiereActualizacion = seRequiereActualizacion;
    }

    public String getTipoDocumentoRepresentanteLegal() {
        return tipoDocumentoRepresentanteLegal;
    }

    public void setTipoDocumentoRepresentanteLegal(String tipoDocumentoRepresentanteLegal) {
        this.tipoDocumentoRepresentanteLegal = tipoDocumentoRepresentanteLegal;
    }

    public String getTotalActivos() {
        return totalActivos;
    }

    public void setTotalActivos(String totalActivos) {
        this.totalActivos = totalActivos;
    }

    public String getUltimaFechaActualizacion() {
        return ultimaFechaActualizacion;
    }

    public void setUltimaFechaActualizacion(String ultimaFechaActualizacion) {
        this.ultimaFechaActualizacion = ultimaFechaActualizacion;
    }
}
