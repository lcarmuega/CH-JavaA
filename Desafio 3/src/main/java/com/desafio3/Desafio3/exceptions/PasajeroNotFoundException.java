package com.desafio3.Desafio3.exceptions;

public class PasajeroNotFoundException extends RuntimeException{
    public PasajeroNotFoundException(Long id){
        super("No se encuentra el pasajero " + id);
    }
}
