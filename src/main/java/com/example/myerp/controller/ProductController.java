package com.example.myerp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<ProductDTO>> getAllClients() {
        return ResponseEntity.ok(
            productService.getAllProducts()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(
            productService.getProductById(id)
        );
    }
    
    @PostMapping
    public ResponseEntity<ProductDTO> createClient(@RequestBody ProductCreateDTO client) {
        return ResponseEntity.ok(
            productService.createProduct(client)
        );
    }
}
