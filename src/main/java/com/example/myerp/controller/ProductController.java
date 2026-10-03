package com.example.myerp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.myerp.dto.ProductCreateDTO;
import com.example.myerp.dto.ProductDTO;
import com.example.myerp.services.ProductService;

@RestController 
@RequestMapping("/product")
public class ProductController {
    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllClients() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getClientById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createClient(@RequestBody ProductCreateDTO client) {
        return productService.createProduct(client);
    }
}
