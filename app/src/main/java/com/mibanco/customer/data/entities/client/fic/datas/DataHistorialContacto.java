package com.mibanco.customer.data.entities.client.fic.datas;

import com.mibanco.customer.data.entities.client.fic.Contacto;

import java.io.Serializable;
import java.util.List;

public class DataHistorialContacto  implements Serializable {
    private List<Contacto> historialContacto;

    public DataHistorialContacto(List<Contacto> historialContacto) {
        this.setHistorialContacto(historialContacto);
    }


    public List<Contacto> getHistorialContacto() {
        return historialContacto;
    }

    public void setHistorialContacto(List<Contacto> historialContacto) {
        this.historialContacto = historialContacto;
    }
}
