package com.desafio3.Desafio3.controllers;


import com.desafio3.Desafio3.entities.VueloEntity;
import com.desafio3.Desafio3.responseobjects.VueloResponseObject;
import com.desafio3.Desafio3.services.VueloService;
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
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping("/vuelos")
    List<VueloResponseObject> getVuelos() {
        return StreamSupport.stream(vueloService.getVuelos().spliterator(), false)
                .map(VueloResponseObject::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/vuelos/{id}")
    VueloResponseObject getVueloById(@PathVariable Long id) {
        return new VueloResponseObject(vueloService.getVueloById(id));
    }

    @PostMapping("/addVuelo")
    VueloEntity addVuelo(@RequestBody VueloEntity vuelo) {
        return vueloService.addVuelo(vuelo);
    }

    @PutMapping("/vuelos/{id}")
    VueloResponseObject updateVuelo(@PathVariable Long id, @RequestBody VueloEntity vuelo){
        return new VueloResponseObject(vueloService.updateVuelo(id, vuelo));
    }

    @DeleteMapping("/vuelos/id")
    void deleteVuelo(@PathVariable Long id) {
        vueloService.deleteVuelo(id);
    }
}
