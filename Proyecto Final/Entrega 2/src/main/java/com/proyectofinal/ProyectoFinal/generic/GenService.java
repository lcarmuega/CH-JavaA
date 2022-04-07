package com.proyectofinal.ProyectoFinal.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GenService<T extends GenEntity<T, ID>, ID> {
    protected final GenRepository<T, ID> genRepository;

    public GenService(GenRepository<T, ID> genRepository) {
        this.genRepository = genRepository;
    }

    public Page<T> get(){
        return this.genRepository.findAll(Pageable.unpaged());
    }

    public Long count(){
        return this.genRepository.count();
    }

    public void deleteById(ID id){
        T previous = this.genRepository.findById(id).orElse(null);

        if(previous != null){
            this.genRepository.deleteById(id);
        }
    }
}
