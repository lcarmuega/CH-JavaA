package com.desafio3.Desafio3.controllers;

import com.desafio3.Desafio3.entities.PasajeroEntity;
import com.desafio3.Desafio3.responseobjects.PasajeroResponseObject;
import com.desafio3.Desafio3.services.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("vuelos/v1")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping("/pasajeros")
    List<PasajeroResponseObject> getPasajeros() {
        return StreamSupport.stream(pasajeroService.getPasajeros().spliterator(), false)
                .map(PasajeroResponseObject::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/pasajeros/{id}")
    PasajeroResponseObject getPasajeroById(@PathVariable Long id) {
        return new PasajeroResponseObject(pasajeroService.getPasajeroById(id));
    }

    @PostMapping("/addPasajero")
    PasajeroEntity addPasajero(@RequestBody PasajeroEntity pasajero) {
        return pasajeroService.addPasajero(pasajero);
    }

    @PutMapping("/pasajeros/{id}")
    PasajeroResponseObject updatePasajero(@PathVariable Long id, @RequestBody PasajeroEntity pasajero){
        return new PasajeroResponseObject(pasajeroService.updatePasajero(id, pasajero));
    }

    @DeleteMapping("/pasajeros/id")
    void deletePasajero(@PathVariable Long id) {
        pasajeroService.deletePasajero(id);
    }
}
