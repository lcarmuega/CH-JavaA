package com.discoveryclient.Desafio4.controllers;

import com.discoveryclient.Desafio4.entities.Product;
import com.discoveryclient.Desafio4.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    Optional<Product> getProductById(@PathVariable Long productId){
        return productRepository.findById(productId);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    @PostMapping("/add")
    Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
