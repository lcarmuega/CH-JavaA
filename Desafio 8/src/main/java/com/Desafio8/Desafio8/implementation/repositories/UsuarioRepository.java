package com.Desafio8.Desafio8.implementation.repositories;

import com.Desafio8.Desafio8.generic.GenRepository;
import com.Desafio8.Desafio8.implementation.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends GenRepository<Usuario, Long> {
}
