package com.project.spring.ecommercebackend.services;

import com.project.spring.ecommercebackend.exceptions.ProductNotFoundException;
import com.project.spring.ecommercebackend.models.Category;
import com.project.spring.ecommercebackend.models.Product;
import com.project.spring.ecommercebackend.repositories.CategoryRepository;
import com.project.spring.ecommercebackend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Category> category = categoryRepository.findByNameIgnoreCase(product.getCategory().getName());

        if (category.isEmpty()) {
            product.setCategory(categoryRepository.save(product.getCategory()));
        } else {
            product.setCategory(category.get());
        }

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isPresent()) {
            Product toUpdate = existingProductOpt.get();
            if (product.getTitle() != null) {
                toUpdate.setTitle(product.getTitle());
            }
            if (product.getDescription() != null) {
                toUpdate.setDescription(product.getDescription());
            }
            if (product.getPrice() != null) {
                toUpdate.setPrice(product.getPrice());
            }
            if (product.getImageUrl() != null) {
                toUpdate.setImageUrl(product.getImageUrl());
            }
            if (product.getCategory() != null) {
                toUpdate.setCategory(product.getCategory());
            }
            return productRepository.save(toUpdate);
        } else {
            System.out.println("Product not found with id: " + id);
            return null;
        }
    }


    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Deleted product with id: " + id;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory_NameAllIgnoreCase(category);
    }


}
