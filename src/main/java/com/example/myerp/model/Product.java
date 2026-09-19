package com.example.myerp.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_sequence")
    @SequenceGenerator(name="product_sequence", sequenceName="product_sequence", allocationSize=100)
    private Long id;

    private String name;

    private String description;

    private float price;
    
}