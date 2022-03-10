package com.desafio2.Desafio2.services;

import com.desafio2.Desafio2.entities.Editorial;
import com.desafio2.Desafio2.entities.Libro;
import com.desafio2.Desafio2.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public void createLibro(Libro libro){
        libroRepository.save(libro);
    }

    public Iterable<Libro> getLibros(){
        return libroRepository.findAll();
    }

    public Libro getLibroById(Long id){
        return (Libro) libroRepository.findById(id).orElse(null);
    }

    public void deleteLibro(Long id){
        libroRepository.deleteById(id);
    }

    public void updateLibro(Long id, Libro libro){
        Libro libroOld = (Libro) libroRepository.findById(id).orElse(null);
        libroOld.setTitulo(libro.getTitulo());
        libroOld.setEditorial(libro.getEditorial());
        libroOld.setAutor(libro.getAutor());
        libroOld.setCategoria(libro.getCategoria());
        libroRepository.save(libroOld);
    }
}
