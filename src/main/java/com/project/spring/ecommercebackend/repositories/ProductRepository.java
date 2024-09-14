package com.project.spring.ecommercebackend.repositories;

import com.project.spring.ecommercebackend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    // List of all product and save options already given by JPARepository
    //List<Product> findAll();
    //Product save(Product product);
    //void deleteById(Long id);

    List<Product> findByCategory_NameAllIgnoreCase(String name);


}
