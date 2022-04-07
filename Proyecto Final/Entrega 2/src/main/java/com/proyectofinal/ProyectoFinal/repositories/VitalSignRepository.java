package com.proyectofinal.ProyectoFinal.repositories;

import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.entities.VitalSign;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VitalSignRepository extends CrudRepository<VitalSign, Integer> {
    public List<VitalSign> findAll();

    public List<VitalSign> findByPatient(Patient patient);
}
