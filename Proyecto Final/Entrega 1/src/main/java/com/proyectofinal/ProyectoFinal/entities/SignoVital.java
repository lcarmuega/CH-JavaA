package com.proyectofinal.ProyectoFinal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "signos_vitales")
public class SignoVital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "signo_vital")
    private String signoVital;

    @Column(name = "valor")
    private Integer valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public SignoVital() {
    }

    public SignoVital(String nombreSV, Integer valor, Paciente paciente) {
        this.signoVital = nombreSV;
        this.valor = valor;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignoVital() {
        return signoVital;
    }

    public void setSignoVital(String nombreSV) {
        this.signoVital = nombreSV;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "SignoVital{" +
                "id=" + id +
                ", nombreSV='" + signoVital + '\'' +
                ", valor=" + valor +
                ", paciente=" + paciente +
                '}';
    }
}

