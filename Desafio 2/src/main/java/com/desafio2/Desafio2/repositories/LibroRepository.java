package com.desafio2.Desafio2.repositories;

import com.desafio2.Desafio2.entities.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro, Long> {
}
