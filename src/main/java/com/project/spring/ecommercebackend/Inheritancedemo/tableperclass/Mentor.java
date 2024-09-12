package com.project.spring.ecommercebackend.Inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User {
    private double averageRating;
    private Long sessionsTaken;
}
