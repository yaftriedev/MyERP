package com.example.myerp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myerp.model.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

}
