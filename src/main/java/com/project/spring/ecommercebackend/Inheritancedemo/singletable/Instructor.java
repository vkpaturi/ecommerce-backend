package com.project.spring.ecommercebackend.Inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_instructor")
@DiscriminatorValue("1")
public class Instructor extends User {
    private String specialization;
}
