package com.project.spring.ecommercebackend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
