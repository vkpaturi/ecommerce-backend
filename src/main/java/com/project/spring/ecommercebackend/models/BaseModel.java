package com.project.spring.ecommercebackend.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass // In this class we don't really need the objects, also we don't need a new table,
// This is just a class for common attributes so using MappedSuperclass Attributes
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date created_At;
    private Date updated_At;
    private boolean is_deleted;
}


// This class is used to put all the common attributes of all the models.
// Basically called the auditing attributes,
// ID, Created_At, updated_at, is_deleted are common examples.

