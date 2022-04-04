package com.proyectofinal.ProyectoFinal.repositories;

import com.proyectofinal.ProyectoFinal.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
    public List<Paciente> findAll();

    public Paciente findByFullName(String fullName);
}
