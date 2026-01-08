package com.example.Git_Practices.controller;
import com.example.Git_Practices.controller.dto.request.CategoryRequestDTO;
import com.example.Git_Practices.model.Category;
import com.example.Git_Practices.repository.CategoryRepository;
import com.example.Git_Practices.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequestDTO requestDTO) {
        return new ResponseEntity<>(categoryService.createCategory(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}