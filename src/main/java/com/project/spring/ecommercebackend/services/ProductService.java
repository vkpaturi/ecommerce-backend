package com.project.spring.ecommercebackend.services;

import com.project.spring.ecommercebackend.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
}
