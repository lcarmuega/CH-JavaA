package com.Desafio8.Desafio8.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GenService<T extends GenEntity<T, ID>, ID> {
    private final GenRepository<T, ID> repository;

    public GenService(GenRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T getById(ID id){
        return this.repository.findById(id).orElse(null);
    }

    public Page<T> get(){
        return this.repository.findAll(Pageable.unpaged());
    }

    public T create(T newT){
        newT.create();
        return repository.save(newT);
    }

    public T update(T updatedT){
        T previous = this.repository.findById(updatedT.getId()).orElse(null);

        if(previous == null) {
            return null;
        }

        previous.update(updatedT);

        return this.repository.save(previous);
    }

    public void delete(ID id){
        T previous = this.repository.findById(id).orElse(null);

        if(previous != null) {
            previous.delete();
            this.repository.save(previous);
        }
    }
}
