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
public class Employee {
    @Id
    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre")
    private String fullName;

    @Column(name = "activo")
    private boolean active;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rol> rol;

    public Employee() {
    }

    public Employee(String user, String password, String fullName, boolean active, List<Rol> rol) {
        this.user = user;
        this.password = password;
        this.fullName = fullName;
        this.active = active;
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", active=" + active +
                ", rol=" + rol +
                '}';
    }
}
