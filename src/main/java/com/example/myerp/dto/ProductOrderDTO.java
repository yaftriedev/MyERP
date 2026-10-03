package com.example.myerp.dto;

import com.example.myerp.model.ProductOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor 
@AllArgsConstructor 
public class ProductOrderDTO {
    private Long id;
    private Long product_id;
    private float price;
    private Short quantity;
    private float total;

    public static ProductOrderDTO fromEntity(ProductOrder productOrder) {
        return new ProductOrderDTO(
            productOrder.getId(),
            productOrder.getProduct().getId(),
            productOrder.getPrice(),
            productOrder.getQuantity(),
            productOrder.getPrice() * productOrder.getQuantity()
        );
    }
}
