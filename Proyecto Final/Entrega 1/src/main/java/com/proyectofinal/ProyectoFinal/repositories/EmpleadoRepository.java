package com.proyectofinal.ProyectoFinal.repositories;

import com.proyectofinal.ProyectoFinal.entities.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, String> {
}
