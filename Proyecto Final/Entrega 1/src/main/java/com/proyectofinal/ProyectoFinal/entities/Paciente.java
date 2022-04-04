package com.proyectofinal.ProyectoFinal.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String fullName;

    @Column(name = "fecha_nacimiento")
    private Date birthDate;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<SignoVital> signosVitales;

    public Paciente() {
    }

    public Paciente(String fullName, Date birthDate, List<SignoVital> signosVitales) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.signosVitales = signosVitales;
    }

    public void addSignoVital(SignoVital signoVital){
        if( this.signosVitales == null) this.signosVitales = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<SignoVital> getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(List<SignoVital> signosVitales) {
        this.signosVitales = signosVitales;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", signosVitales=" + signosVitales +
                '}';
    }
}
