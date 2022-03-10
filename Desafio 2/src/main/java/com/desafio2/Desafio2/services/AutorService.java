package com.desafio2.Desafio2.services;

import com.desafio2.Desafio2.entities.Autor;
import com.desafio2.Desafio2.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public void createAutor(Autor autor){
        autorRepository.save(autor);
    }

    public Iterable<Autor> getAutores(){
        return autorRepository.findAll();
    }

    public Autor getAutorById(Long id){
        return autorRepository.findById(id).orElse(null);
    }

    public void deleteAutor(Long id){
        autorRepository.deleteById(id);
    }

    public void updateAutor(Long id, Autor autor){
        Autor autorOld = autorRepository.findById(id).orElse(null);
        autorOld.setNombreCompleto(autor.getNombreCompleto());
        autorRepository.save(autorOld);
    }

}
