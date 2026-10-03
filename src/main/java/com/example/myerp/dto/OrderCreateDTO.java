package com.example.myerp.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor 
public class OrderCreateDTO {    
    private Long client_id;

    private List<ProductOrderCreateDTO> products;
}
