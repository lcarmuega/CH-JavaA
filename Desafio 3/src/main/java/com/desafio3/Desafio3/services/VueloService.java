package com.desafio3.Desafio3.services;

import com.desafio3.Desafio3.entities.VueloEntity;
import com.desafio3.Desafio3.exceptions.VueloNotFoundException;
import com.desafio3.Desafio3.repositories.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    public Iterable<VueloEntity> getVuelos() {
        return vueloRepository.findAll();
    }

    public VueloEntity getVueloById(Long id) {
        return vueloRepository.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
    }

    public VueloEntity addVuelo(VueloEntity vuelo) {
        return vueloRepository.save(vuelo);
    }

    public VueloEntity updateVuelo(Long id, VueloEntity newVuelo) {
        return vueloRepository.findById(id).map(vuelo -> {
            vuelo.setAvion(newVuelo.getAvion());
            vuelo.setCiudadDestino(newVuelo.getCiudadDestino());
            vuelo.setCiudadOrigen(newVuelo.getCiudadOrigen());
            vuelo.setPasajeros(newVuelo.getPasajeros());
            return vueloRepository.save(vuelo);
        }).orElseGet(() -> {
            return vueloRepository.save(newVuelo);
        });
    }

    public void deleteVuelo(Long id){
        vueloRepository.deleteById(id);
    }
}
