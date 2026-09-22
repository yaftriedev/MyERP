package com.example.myerp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myerp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
