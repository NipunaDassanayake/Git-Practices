package com.example.Git_Practices.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // Added price field to Product entity
    private Double price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public boolean isValidPrice() {
        return this.price > 0;
    }
}