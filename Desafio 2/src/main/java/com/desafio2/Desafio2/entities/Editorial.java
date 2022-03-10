package com.desafio2.Desafio2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="editorial")
public class Editorial {
    @Id
    @Column(name="editorial_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="editorial")
    private String editorial;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "editorial")
    private List<Libro> libros;

    public Editorial() {}

    public Editorial(String editorial) {
        this.editorial = editorial;
        this.libros = new ArrayList<Libro>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id = " + id +
                ", nombre = " + editorial +
                "}";
    }
}
