package com.desafio3.Desafio3.responseobjects;

import com.desafio3.Desafio3.entities.AvionEntity;
import com.desafio3.Desafio3.entities.VueloEntity;

import java.util.List;

public class AvionResponseObject {

    private Long id;
    private Integer cantidadAsientos;
    private List<VueloEntity> vuelos;

    public AvionResponseObject() {
    }

    public AvionResponseObject(AvionEntity avion) {
        this.id = avion.getId();
        this.cantidadAsientos = avion.getCantidadAsientos();
        this.vuelos = avion.getVuelos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(Integer cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }
}
