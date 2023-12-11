package com.mibanco.customer.data.entities.client;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TotalClient implements Serializable {
    @SerializedName("totalClientes")
    private String totalClientes;
    @SerializedName("clientes")
    private List<Client>  clientes;


    public String getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(String totalClientes) {
        this.totalClientes = totalClientes;
    }

    public List<Client> getClientes() {
        return clientes;
    }

    public void setClientes(List<Client> clientes) {
        this.clientes = clientes;
    }
}
