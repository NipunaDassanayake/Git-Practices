package com.example.Git_Practices.service.impl;
import com.example.Git_Practices.controller.dto.request.CategoryRequestDTO;
import com.example.Git_Practices.model.Category;
import com.example.Git_Practices.repository.CategoryRepository;
import com.example.Git_Practices.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryRequestDTO requestDTO) {
        Category category = new Category();
        category.setTitle(requestDTO.getTitle());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
