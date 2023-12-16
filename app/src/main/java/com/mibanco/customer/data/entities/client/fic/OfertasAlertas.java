package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;
import java.util.List;

public class OfertasAlertas implements Serializable {

    private List<Oferta> ofertas;
    private List<Alerta> alertas;

    public OfertasAlertas(List<Oferta> ofertas, List<Alerta> alertas) {
        this.setOfertas(ofertas);
        this.setAlertas(alertas);
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }
}
