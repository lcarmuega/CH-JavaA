package com.proyectofinal.ProyectoFinal.entities;

import com.proyectofinal.ProyectoFinal.generic.GenEntity;

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
public class VitalSign implements GenEntity<VitalSign, Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "signo_vital")
    private String vitalSign;

    @Column(name = "valor")
    private Integer valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Patient patient;

    public VitalSign() {
    }

    public VitalSign(String vsName, Integer valor, Patient patient) {
        this.vitalSign = vsName;
        this.valor = valor;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(String nombreSV) {
        this.vitalSign = nombreSV;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "VitalSign{" +
                "id=" + id +
                ", vitalSign='" + vitalSign + '\'' +
                ", valor=" + valor +
                ", patient=" + patient +
                '}';
    }
}

