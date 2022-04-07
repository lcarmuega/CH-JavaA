package com.Desafio8.Desafio8.implementation.services;

import com.Desafio8.Desafio8.generic.GenService;
import com.Desafio8.Desafio8.implementation.entities.Usuario;
import com.Desafio8.Desafio8.implementation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenService<Usuario, Long> {
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        super(usuarioRepository);
    }
}
