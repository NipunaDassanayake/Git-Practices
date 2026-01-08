package com.example.Git_Practices.service.impl;
import com.example.Git_Practices.controller.dto.request.CategoryRequestDTO;
import com.example.Git_Practices.controller.dto.response.CategoryResponseDTO;
import com.example.Git_Practices.model.Category;
import com.example.Git_Practices.repository.CategoryRepository;
import com.example.Git_Practices.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryRequestDTO requestDTO) {

        if (categoryRepository.existsByTitle(requestDTO.getTitle())) {
            throw new RuntimeException("Category with title '" + requestDTO.getTitle() + "' already exists.");
        }
        Category category = new Category();
        category.setTitle(requestDTO.getTitle());
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> {
                    CategoryResponseDTO dto = new CategoryResponseDTO();
                    dto.setId(category.getId());
                    dto.setTitle(category.getTitle());
                    return dto;
                }).collect(Collectors.toList());
    }
}
