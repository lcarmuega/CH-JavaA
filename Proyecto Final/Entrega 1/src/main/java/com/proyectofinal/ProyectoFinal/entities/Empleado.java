package com.proyectofinal.ProyectoFinal.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rol> rol;

    public Empleado() {
    }

    public Empleado(String user, String password, List<Rol> rol) {
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
