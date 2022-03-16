package com.desafio3.Desafio3.responseobjects;

import com.desafio3.Desafio3.entities.AvionEntity;
import com.desafio3.Desafio3.entities.PasajeroEntity;
import com.desafio3.Desafio3.entities.VueloEntity;

import java.util.List;

public class VueloResponseObject {

    private Long id;
    private String ciudadDestino;
    private String ciudadOrigen;
    private AvionEntity avion;
    private List<PasajeroEntity> pasajeros;

    public VueloResponseObject() {
    }

    public VueloResponseObject(VueloEntity vuelo) {
        this.id = vuelo.getId();
        this.ciudadDestino = vuelo.getCiudadDestino();
        this.ciudadOrigen = vuelo.getCiudadOrigen();
        this.avion = vuelo.getAvion();
        this.pasajeros = vuelo.getPasajeros();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }
}
