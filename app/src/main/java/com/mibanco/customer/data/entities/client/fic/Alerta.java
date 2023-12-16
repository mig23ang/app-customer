package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;

public class Alerta implements Serializable {


    private int id;
    private String tipo;
    private String banco;
    private String fecha;


    public Alerta(int id, String tipo, String banco, String fecha) {
        this.setId(id);
        this.setTipo(tipo);
        this.setBanco(banco);
        this.setFecha(fecha);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
