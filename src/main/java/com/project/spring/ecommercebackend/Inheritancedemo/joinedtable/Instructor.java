package com.project.spring.ecommercebackend.Inheritancedemo.joinedtable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructor")

public class Instructor extends User {
    private String specialization;
}
