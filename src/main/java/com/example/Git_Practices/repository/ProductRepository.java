package com.example.Git_Practices.repository;

import com.example.Git_Practices.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query: Find all products belonging to a specific category ID
    List<Product> findByCategoryId(Long categoryId);

    // Custom query: Find products cheaper than a certain price
    List<Product> findByPriceLessThan(Double price);
}