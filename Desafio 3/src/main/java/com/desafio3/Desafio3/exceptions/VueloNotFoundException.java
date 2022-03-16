package com.desafio3.Desafio3.exceptions;

public class VueloNotFoundException extends RuntimeException {
    public VueloNotFoundException(Long id){
        super("No se encuentra el vuelo " + id);
    }
}
