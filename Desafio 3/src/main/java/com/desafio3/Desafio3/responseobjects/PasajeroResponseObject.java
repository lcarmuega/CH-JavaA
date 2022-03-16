package com.desafio3.Desafio3.responseobjects;

import com.desafio3.Desafio3.entities.PasajeroEntity;
import com.desafio3.Desafio3.entities.VueloEntity;

import java.util.List;

public class PasajeroResponseObject {

    private Long id;
    private String nombreCompleto;
    private String documento;
    private List<VueloEntity> vuelos;

    public PasajeroResponseObject() {
    }

    public PasajeroResponseObject(PasajeroEntity pasajero) {
        this.id = pasajero.getId();
        this.documento = pasajero.getDocumento();
        this.nombreCompleto = pasajero.getNombreCompleto();
        this.vuelos = pasajero.getVuelos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
