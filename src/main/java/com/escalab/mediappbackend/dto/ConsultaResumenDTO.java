package com.escalab.mediappbackend.dto;

import java.util.Date;

public class ConsultaResumenDTO {

    private Integer cantidad;
    private String fecha;

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
