package com.example.myerp.dto;

import java.util.Date;
import java.util.List;

import com.example.myerp.model.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
@AllArgsConstructor 
public class OrderDTO {
    private Long id;

    private Date date;
    
    private Long client_id;

    private List<ProductOrderDTO> products;

    public static OrderDTO fromEntity(Order order) {
        return new OrderDTO(
            order.getId(),
            order.getDate(),
            order.getClient().getId(),
            order.getProducts()
                .stream()
                .map(ProductOrderDTO::fromEntity)
                .toList()
        );
    }
}
