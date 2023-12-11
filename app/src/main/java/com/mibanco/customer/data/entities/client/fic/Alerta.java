package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Alerta implements Serializable {
    private String tipoAlerta;
    private String banco;
    private String fecha;
    private String tipoDocumento;
    private String numeroDocumento;
    private String digitoVerificacion;

    public Alerta(String tipoAlerta, String banco, String fecha, String tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        this.setTipoAlerta(tipoAlerta);
        this.setBanco(banco);
        this.setFecha(fecha);
        this.setTipoDocumento(tipoDocumento);
        this.setNumeroDocumento(numeroDocumento);
        this.setDigitoVerificacion(digitoVerificacion);
    }


    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }
}
