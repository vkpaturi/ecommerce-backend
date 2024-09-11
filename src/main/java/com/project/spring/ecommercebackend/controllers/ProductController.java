package com.project.spring.ecommercebackend.controllers;

import com.project.spring.ecommercebackend.models.Product;
import com.project.spring.ecommercebackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    // localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // localhost:8080/products
    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        return null;
    }

    // localhost:8080/products/1
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return null;
    }

    // localhost:8080/products/1
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return null;
    }

    // localhost:8080/products/1
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) {
        return null;
    }

}
