package com.desafio2.Desafio2.services;

import com.desafio2.Desafio2.entities.Categoria;
import com.desafio2.Desafio2.entities.Editorial;
import com.desafio2.Desafio2.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;

    public void createEditorial(Editorial editorial){
        editorialRepository.save(editorial);
    }

    public Iterable<Editorial> getEditoriales(){
        return editorialRepository.findAll();
    }

    public Editorial getEditorialById(Long id){
        return editorialRepository.findById(id).orElse(null);
    }

    public void deleteEditorial(Long id){
        editorialRepository.deleteById(id);
    }

    public void updateEditorial(Long id, Editorial editorial){
        Editorial editorialOld = editorialRepository.findById(id).orElse(null);
        editorialOld.setEditorial(editorial.getEditorial());
        editorialRepository.save(editorialOld);
    }
}
