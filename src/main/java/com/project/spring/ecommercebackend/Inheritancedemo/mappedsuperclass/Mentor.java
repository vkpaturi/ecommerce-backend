package com.project.spring.ecommercebackend.Inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_mentor")
public class Mentor extends User{
    private double averageRating;
    private Long sessionsTaken;
}
