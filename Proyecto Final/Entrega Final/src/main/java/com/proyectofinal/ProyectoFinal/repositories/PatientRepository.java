package com.proyectofinal.ProyectoFinal.repositories;

import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.generic.GenRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends GenRepository<Patient, Integer> {
    public List<Patient> findAll();

    public Patient findByFullName(String fullName);
}
