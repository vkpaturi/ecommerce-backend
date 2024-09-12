package com.project.spring.ecommercebackend.Inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private double averageRating;
    private Long sessionsTaken;
}
