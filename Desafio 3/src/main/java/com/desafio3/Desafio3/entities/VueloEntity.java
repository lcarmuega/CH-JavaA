package com.desafio3.Desafio3.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vuelo")
public class VueloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vuelo_id")
    private Long id;

    @Column(name = "ciudad_destino")
    private String ciudadDestino;

    @Column(name = "ciudad_origen")
    private String ciudadOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="avion_id")
    private AvionEntity avion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "pasajeros_vuelos",
            joinColumns = @JoinColumn(name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "pasajero_id"))
    private List<PasajeroEntity> pasajeros;

    public VueloEntity() {
    }

    public VueloEntity(String ciudadDestino, String ciudadOrigen, AvionEntity avion, List<PasajeroEntity> pasajeros) {
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.avion = avion;
        this.pasajeros = pasajeros;
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

    public AvionEntity getAvion() {
        return avion;
    }

    public void setAvion(AvionEntity avion) {
        this.avion = avion;
    }

    public List<PasajeroEntity> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<PasajeroEntity> pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        return "VueloEntity{" +
                "id=" + id +
                ", ciudadDestino='" + ciudadDestino + '\'' +
                ", ciudadOrigen='" + ciudadOrigen + '\'' +
                ", avion=" + avion +
                ", pasajeros=" + pasajeros +
                '}';
    }
}
