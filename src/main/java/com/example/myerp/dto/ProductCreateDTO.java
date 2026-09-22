package com.example.myerp.dto;

import com.example.myerp.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter 
public class ProductCreateDTO {

    private String name;

    private String description;

    private float price;   

    public static ProductCreateDTO fromEntity(Product s) {
        return new ProductCreateDTO(
            s.getName(),
            s.getDescription(),
            s.getPrice()
        );
    }    
}
