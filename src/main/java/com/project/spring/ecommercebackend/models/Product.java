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
    private double price;
    private String imageUrl;

    @ManyToOne
    private Category category;
}

// Product and Category ->  M : 1
