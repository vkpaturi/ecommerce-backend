package com.project.spring.ecommercebackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Long numberOfOrders;

    @ManyToOne
    private Category category;
}

// Product and Category ->  M : 1
