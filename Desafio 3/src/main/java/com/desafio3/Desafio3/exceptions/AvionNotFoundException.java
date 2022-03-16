package com.desafio3.Desafio3.exceptions;

public class AvionNotFoundException extends RuntimeException {
    public AvionNotFoundException(Long id){
        super("No se encuentra el avion " + id);
    }
}
