package com.desafio3.Desafio3.services;

import com.desafio3.Desafio3.entities.PasajeroEntity;
import com.desafio3.Desafio3.exceptions.PasajeroNotFoundException;
import com.desafio3.Desafio3.repositories.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasajeroService {
    @Autowired
    private PasajeroRepository pasajeroRepository;

    public Iterable<PasajeroEntity> getPasajeros(){
        return pasajeroRepository.findAll();
    }

    public PasajeroEntity getPasajeroById(Long id){
        return pasajeroRepository.findById(id).orElseThrow(() -> new PasajeroNotFoundException(id));
    }

    public PasajeroEntity addPasajero(PasajeroEntity pasajero){
        return pasajeroRepository.save(pasajero);
    }

    public PasajeroEntity updatePasajero(Long id, PasajeroEntity newPasajero) {
        return pasajeroRepository.findById(id).map(pasajero -> {
            pasajero.setDocumento(newPasajero.getDocumento());
            pasajero.setNombreCompleto(newPasajero.getNombreCompleto());
            pasajero.setVuelos(newPasajero.getVuelos());
            return pasajeroRepository.save(pasajero);
        }).orElseGet(() -> {
            return pasajeroRepository.save(newPasajero);
        });
    }

    public void deletePasajero(Long id){
        pasajeroRepository.deleteById(id);
    }
}
