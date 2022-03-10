package com.desafio2.Desafio2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="autor")
public class Autor {
    @Id
    @Column(name="autor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre_completo")
    private String nombreCompleto;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {}

    public Autor(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        this.libros = new ArrayList<Libro>();
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

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id = " + id +
                ", nombre = " + nombreCompleto +
                "}";
    }
}
