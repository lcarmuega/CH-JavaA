package com.Desafio8.Desafio8.generic;

public interface GenEntity<T, ID> {
    ID getId();
    void create();
    void update(T newT);
    void delete();
}
