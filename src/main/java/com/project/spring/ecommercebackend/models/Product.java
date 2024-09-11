package com.project.spring.ecommercebackend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
