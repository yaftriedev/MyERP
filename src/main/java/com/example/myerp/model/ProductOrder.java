package com.example.myerp.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productorder")
public class ProductOrder implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productorder_sequence")
    @SequenceGenerator(name="productorder_sequence", sequenceName="productorder_sequence", allocationSize=100)
    private Long id;

    @ManyToOne 
    private Order order;

    @ManyToOne
    private Product product;

    private Short quantity;
    
}