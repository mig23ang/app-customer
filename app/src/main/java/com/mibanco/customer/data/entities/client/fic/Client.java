package com.mibanco.customer.data.entities.client.fic;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {
    private  int id;
    private String tipoIdentificacion;
    private String identificacion;
    private String numeroCliente;
    private String nombreCompleto;
    private String correoElectronico;
    private String estadoCivil;
    private String telefono1;
    private String telefono2;
    private String tipoVivienda;
    private String totalActivos;
    private String ultimaFechaActualizacion;
    private String funcionarioRealizoActualizacion;
    private String requiereActualizacion;
    private String ciudad;
    private String pais;
    private Domicilio domicilio;
    private Negocio negocio;
    private OfertasAlertas ofertasAlertas;

    private List<CentralRiesgo> centralesRiesgo;

    private Conyuge conyuge;


    public Client(int id, String tipoIdentificacion, String identificacion, String numeroCliente, String nombreCompleto, String correoElectronico, String estadoCivil, String telefono1, String telefono2, String tipoVivienda, String totalActivos, String ultimaFechaActualizacion, String funcionarioRealizoActualizacion, String requiereActualizacion, String ciudad, String pais, Domicilio domicilio, Negocio negocio, OfertasAlertas ofertasAlertas, Conyuge conyuge, List<CentralRiesgo> centralesRiesgo) {
        this.setId(id);
        this.setTipoIdentificacion(tipoIdentificacion);
        this.setIdentificacion(identificacion);
        this.setNumeroCliente(numeroCliente);
        this.setNombreCompleto(nombreCompleto);
        this.setCorreoElectronico(correoElectronico);
        this.setEstadoCivil(estadoCivil);
        this.setTelefono1(telefono1);
        this.setTelefono2(telefono2);
        this.setTipoVivienda(tipoVivienda);
        this.setTotalActivos(totalActivos);
        this.setUltimaFechaActualizacion(ultimaFechaActualizacion);
        this.setFuncionarioRealizoActualizacion(funcionarioRealizoActualizacion);
        this.setRequiereActualizacion(requiereActualizacion);
        this.setCiudad(ciudad);
        this.setPais(pais);
        this.setDomicilio(domicilio);
        this.setNegocio(negocio);
        this.setOfertasAlertas(ofertasAlertas);
        this.setConyuge(conyuge);
        this.setCentralesRiesgo(centralesRiesgo);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
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

    public String getFuncionarioRealizoActualizacion() {
        return funcionarioRealizoActualizacion;
    }

    public void setFuncionarioRealizoActualizacion(String funcionarioRealizoActualizacion) {
        this.funcionarioRealizoActualizacion = funcionarioRealizoActualizacion;
    }

    public String getRequiereActualizacion() {
        return requiereActualizacion;
    }

    public void setRequiereActualizacion(String requiereActualizacion) {
        this.requiereActualizacion = requiereActualizacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public OfertasAlertas getOfertasAlertas() {
        return ofertasAlertas;
    }

    public void setOfertasAlertas(OfertasAlertas ofertasAlertas) {
        this.ofertasAlertas = ofertasAlertas;
    }

    public Conyuge getConyuge() {
        return conyuge;
    }

    public void setConyuge(Conyuge conyuge) {
        this.conyuge = conyuge;
    }

    public List<CentralRiesgo> getCentralesRiesgo() {
        return centralesRiesgo;
    }

    public void setCentralesRiesgo(List<CentralRiesgo> centralesRiesgo) {
        this.centralesRiesgo = centralesRiesgo;
    }
}
