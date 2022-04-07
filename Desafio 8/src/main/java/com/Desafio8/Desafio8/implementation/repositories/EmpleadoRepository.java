package com.Desafio8.Desafio8.implementation.repositories;


import com.Desafio8.Desafio8.generic.GenRepository;
import com.Desafio8.Desafio8.implementation.entities.Empleado;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends GenRepository<Empleado, String> {
}
