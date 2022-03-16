package com.desafio3.Desafio3.controllers;


import com.desafio3.Desafio3.entities.AvionEntity;
import com.desafio3.Desafio3.responseobjects.AvionResponseObject;
import com.desafio3.Desafio3.services.AvionService;
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
public class AvionController {

    @Autowired
    private AvionService avionService;

    @GetMapping("/aviones")
    List<AvionResponseObject> getAviones() {
        return StreamSupport.stream(avionService.getAviones().spliterator(), false)
                .map(AvionResponseObject::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/aviones/{id}")
    AvionResponseObject getAvionById(@PathVariable Long id) {
        return new AvionResponseObject(avionService.getAvionById(id));
    }

    @PostMapping("/addAvion")
    AvionEntity addAvion(@RequestBody AvionEntity avion) {
        return avionService.addAvion(avion);
    }

    @PutMapping("/aviones/{id}")
    AvionResponseObject updateAvion(@PathVariable Long id, @RequestBody AvionEntity avion){
        return new AvionResponseObject(avionService.updateAvion(id, avion));
    }

    @DeleteMapping("/aviones/id")
    void deleteAvion(@PathVariable Long id) {
        avionService.deleteAvion(id);
    }
}
