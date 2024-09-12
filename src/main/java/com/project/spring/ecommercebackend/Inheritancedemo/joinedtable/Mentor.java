package com.project.spring.ecommercebackend.Inheritancedemo.joinedtable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
public class Mentor extends User {
    private double averageRating;
    private Long sessionsTaken;
}
