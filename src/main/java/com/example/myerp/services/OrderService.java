package com.example.myerp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.myerp.dto.OrderCreateDTO;
import com.example.myerp.dto.OrderDTO;
import com.example.myerp.error.ErrorException;
import com.example.myerp.model.Client;
import com.example.myerp.model.Order;
import com.example.myerp.model.Product;
import com.example.myerp.model.ProductOrder;
import com.example.myerp.repository.ClientRepository;
import com.example.myerp.repository.OrderRepository;
import com.example.myerp.repository.ProductOrderRepository;
import com.example.myerp.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service 
public class OrderService {
    
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private ProductRepository productRepository;

    public OrderService(
        OrderRepository orderRepository,
        ProductOrderRepository productOrderRepository,
        ClientRepository clientRepository,
        ProductRepository productRepository
    ) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Transactional 
    public OrderDTO createOrder(OrderCreateDTO orderCreateDTO) {

        Order order = new Order();

        Client client = clientRepository.findById(orderCreateDTO.getClient_id())
            .orElseThrow(
                () -> new ErrorException(
                    "El ClientID " + orderCreateDTO.getClient_id() + " no existe"
                )
            );

        order.setClient(client);
        order.setDate(new Date());
        
        orderRepository.save(order);

        List<ProductOrder> products = orderCreateDTO.getProducts()
            .stream()
            .map(p -> {
                
                Product product = productRepository.findById(
                p.getProduct_id()
                    ).orElseThrow(
                        () -> new ErrorException(
                            "El ProductID " + p.getProduct_id() + " no existe"
                        )
                    );

                ProductOrder productOrder = new ProductOrder();

                productOrder.setOrder(order);
                productOrder.setProduct(product);
                productOrder.setPrice(p.getPrice());
                productOrder.setQuantity(p.getQuantity());

                return productOrder;
            })
            .collect(Collectors.toCollection(ArrayList::new));

        order.setProducts(products);

        orderRepository.save(order);

        return OrderDTO.fromEntity(order);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
            .stream()
            .map(OrderDTO::fromEntity)
            .toList();
    }

    public OrderDTO getOrderById(Long id) {
        return OrderDTO.fromEntity(
            orderRepository.findById(id)
                .orElseThrow(() -> new ErrorException("Ese ID no existe"))
        );
    }

}
