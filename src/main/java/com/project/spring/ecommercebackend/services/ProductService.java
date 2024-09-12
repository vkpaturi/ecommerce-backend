package com.project.spring.ecommercebackend.services;

import com.project.spring.ecommercebackend.dtos.FakeStoreResponseDTO;
import com.project.spring.ecommercebackend.exceptions.ProductNotFoundException;
import com.project.spring.ecommercebackend.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id, Product product);
    Product deleteProduct(Long id);
}
