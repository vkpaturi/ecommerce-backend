package com.project.spring.ecommercebackend.Inheritancedemo.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
