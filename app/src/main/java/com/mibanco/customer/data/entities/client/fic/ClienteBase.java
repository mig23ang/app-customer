package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class ClienteBase implements Serializable {
    private String id;
    private String numeroCliente;
    private String tipoPersona;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fechaExpedicionDocumento;
    private String primerNombre;
    private String numeroCelular;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;

    public ClienteBase(String id, String numeroCliente, String tipoPersona, String tipoDocumento, String numeroDocumento, String fechaExpedicionDocumento, String primerNombre, String numeroCelular, String segundoNombre, String primerApellido, String segundoApellido, String correoElectronico) {
        this.setId(id);
        this.setNumeroCliente(numeroCliente);
        this.setTipoPersona(tipoPersona);
        this.setTipoDocumento(tipoDocumento);
        this.setNumeroDocumento(numeroDocumento);
        this.setFechaExpedicionDocumento(fechaExpedicionDocumento);
        this.setPrimerNombre(primerNombre);
        this.setNumeroCelular(numeroCelular);
        this.setSegundoNombre(segundoNombre);
        this.setPrimerApellido(primerApellido);
        this.setSegundoApellido(segundoApellido);
        this.setCorreoElectronico(correoElectronico);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaExpedicionDocumento() {
        return fechaExpedicionDocumento;
    }

    public void setFechaExpedicionDocumento(String fechaExpedicionDocumento) {
        this.fechaExpedicionDocumento = fechaExpedicionDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
