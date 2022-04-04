package com.proyectofinal.ProyectoFinal.repositories;

import com.proyectofinal.ProyectoFinal.entities.Paciente;
import com.proyectofinal.ProyectoFinal.entities.SignoVital;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SignoVitalRepository extends CrudRepository<SignoVital, Integer> {
    public List<SignoVital> findAll();

    public List<SignoVital> findByPaciente(Paciente paciente);
}
