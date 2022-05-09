package com.proyectofinal.ProyectoFinal.repositories;

import com.proyectofinal.ProyectoFinal.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
