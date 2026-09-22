package com.example.myerp.dto;

import com.example.myerp.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor 
@Setter 
@Getter 
public class ProductDTO {
    private Long id;

    private String name;

    private String description;

    private float price;   

    public static ProductDTO fromEntity(Product s) {
        return new ProductDTO(
            s.getId(),
            s.getName(),
            s.getDescription(),
            s.getPrice()
        );
    }
}
