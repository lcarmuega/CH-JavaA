package com.discoveryclient.Desafio4.repositories;

import com.discoveryclient.Desafio4.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
