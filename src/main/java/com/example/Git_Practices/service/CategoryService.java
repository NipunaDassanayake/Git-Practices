package com.example.Git_Practices.service;
import com.example.Git_Practices.controller.dto.request.CategoryRequestDTO;
import com.example.Git_Practices.model.Category;
import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryRequestDTO requestDTO);
    List<Category> getAllCategories();
}