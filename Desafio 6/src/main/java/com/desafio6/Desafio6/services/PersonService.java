package com.desafio6.Desafio6.services;

import com.desafio6.Desafio6.entities.Person;
import com.desafio6.Desafio6.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public List<Person> addPersons(List<Person> persons){
        return persons.stream()
                .map(person -> {
                    try{
                        return personRepository.save(person);
                    } catch (Exception e){
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El alias no puede estar vacio");
                    }
                }).collect(Collectors.toList());
    }
}
