package com.example.Git_Practices.repository;
import com.example.Git_Practices.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Spring generates all CRUD methods automatically!
    boolean existsByTitle(String title);
    Category findByTitle(String title);
}