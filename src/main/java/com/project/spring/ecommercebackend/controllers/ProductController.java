package com.project.spring.ecommercebackend.controllers;

import com.project.spring.ecommercebackend.exceptions.ProductNotFoundException;
import com.project.spring.ecommercebackend.models.Category;
import com.project.spring.ecommercebackend.models.Product;
import com.project.spring.ecommercebackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }


    // localhost:8080/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
    }

    // localhost:8080/products
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

    }

    // localhost:8080/products --> Response same as the Fakestore one.
//    @PostMapping()
//    public FakeStoreDTO addProduct(@RequestBody Product product) {
//        return productService.addProduct(product);
//    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);

    }

    // localhost:8080/products/1
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);

    }

    // localhost:8080/products/1
    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.replaceProduct(id, product), HttpStatus.OK);
    }

    // localhost:8080/products/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @GetMapping("/categories/{name}")
    public ResponseEntity<List<Product>> getProductsByCategoryByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(productService.getProductsByCategory(name), HttpStatus.OK);
    }

}
