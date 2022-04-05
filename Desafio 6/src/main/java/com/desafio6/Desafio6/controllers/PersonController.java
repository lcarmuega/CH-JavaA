package com.desafio6.Desafio6.controllers;

import com.desafio6.Desafio6.entities.Person;
import com.desafio6.Desafio6.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @PostMapping("/persons/bunch")
    public List<Person> addPersons(@RequestBody List<Person> persons){
        return personService.addPersons(persons);
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
}
