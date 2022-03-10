package com.desafio2.Desafio2.services;

import com.desafio2.Desafio2.entities.Autor;
import com.desafio2.Desafio2.entities.Categoria;
import com.desafio2.Desafio2.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void createCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    public void deleteCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

    public void updateCategoria(Long id, Categoria categoria){
        Categoria categoriaOld = categoriaRepository.findById(id).orElse(null);
        categoriaOld.setCategoria(categoria.getCategoria());
        categoriaRepository.save(categoriaOld);
    }
}
