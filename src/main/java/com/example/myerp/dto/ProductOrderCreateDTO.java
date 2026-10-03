package com.example.myerp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor 
public class ProductOrderCreateDTO {
    private Long product_id;
    private float price;
    private Short quantity;
}
