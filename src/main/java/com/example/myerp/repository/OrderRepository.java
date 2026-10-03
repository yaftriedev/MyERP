package com.example.myerp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myerp.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
