package com.Desafio8.Desafio8.implementation.entities;

import com.Desafio8.Desafio8.generic.GenEntity;

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
public class Empleado implements GenEntity<Empleado, String> {
    @Id
    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "autorizado")
    private boolean auth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rol> rol;

    public Empleado() {
    }

    public Empleado(String user, String password, boolean auth, List<Rol> rol) {
        this.user = user;
        this.password = password;
        this.auth = auth;
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

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
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

    @Override
    public String getId(){
        return this.user;
    }

    @Override
    public void create(){
        this.auth = true;
    }

    @Override
    public void update(Empleado empleado){
        this.password = empleado.getPassword();
    }

    @Override
    public void delete() {
        this.auth = false;
    }

}
