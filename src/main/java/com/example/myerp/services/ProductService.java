package com.example.myerp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myerp.dto.ProductCreateDTO;
import com.example.myerp.dto.ProductDTO;
import com.example.myerp.error.ErrorException;
import com.example.myerp.model.Product;
import com.example.myerp.repository.ProductRepository;

@Service 
public class ProductService {
    
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductCreateDTO productCreateDTO) {
        
        String name = productCreateDTO.getName();
        String description = productCreateDTO.getDescription();
        Float price = productCreateDTO.getPrice();

        if (name == null || name.isBlank()) {
            throw new ErrorException(
                "El nombre no puede estar en blanco o ser nulo"
            );
        }

        if (description == null || description.isBlank()) {
            throw new ErrorException(
                "La descripcion no puede estar en blanco o ser nulo"
            );
        }

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        productRepository.save(product);

        return ProductDTO.fromEntity(product); 
    }

    public Product getProductById(Long id) {
        return productRepository
            .findById(id)
            .orElseThrow(
                () -> new ErrorException("El ID " + id.toString() + " no existe")
            );
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
            .stream()
            .map(ProductDTO::fromEntity)
            .toList();
    }

}
