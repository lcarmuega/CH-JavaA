package com.desafio3.Desafio3.services;

import com.desafio3.Desafio3.entities.AvionEntity;
import com.desafio3.Desafio3.exceptions.AvionNotFoundException;
import com.desafio3.Desafio3.repositories.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionService {
    @Autowired
    private AvionRepository avionRepository;

    public Iterable<AvionEntity> getAviones(){
        return avionRepository.findAll();
    }

    public AvionEntity getAvionById(Long id){
        return avionRepository.findById(id).orElseThrow(() -> new AvionNotFoundException(id));
    }

    public AvionEntity addAvion(AvionEntity avion){
        return avionRepository.save(avion);
    }

    public AvionEntity updateAvion(Long id, AvionEntity newAvion){
        return avionRepository.findById(id).map(avion -> {
            avion.setCantidadAsientos(newAvion.getCantidadAsientos());
            avion.setVuelos(newAvion.getVuelos());
            return avionRepository.save(avion);
        }).orElseGet(() -> {
            return avionRepository.save(newAvion);
        });
    }

    public void deleteAvion(Long id){
        avionRepository.deleteById(id);
    }
}
