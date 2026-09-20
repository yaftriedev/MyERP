package com.example.myerp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myerp.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
