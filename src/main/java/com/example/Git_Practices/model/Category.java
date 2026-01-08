package com.example.Git_Practices.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@ToString(exclude = "products") // Prevents infinite recursion
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}