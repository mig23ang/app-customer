package com.mibanco.customer.data.entities;

public class UserRequest {
    private String correo = "";
    private String clave = "";


    public UserRequest(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
}
