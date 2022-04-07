package com.Desafio8.Desafio8.implementation.controllers;

import com.Desafio8.Desafio8.generic.GenController;
import com.Desafio8.Desafio8.generic.GenService;
import com.Desafio8.Desafio8.implementation.entities.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController extends GenController<Usuario, Long> {
    protected UsuarioController(GenService<Usuario, Long> genService) {
        super(genService);
    }
}
