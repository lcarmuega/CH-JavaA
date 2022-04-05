package com.desafio6.Desafio6.repositories;

import com.desafio6.Desafio6.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findAll();
}
