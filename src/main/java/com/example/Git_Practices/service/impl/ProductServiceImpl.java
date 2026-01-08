package com.example.Git_Practices.service.impl;
import com.example.Git_Practices.controller.dto.request.NewProductRequestDTO;
import com.example.Git_Practices.controller.dto.response.ProductResponseDTO;
import com.example.Git_Practices.model.Category;
import com.example.Git_Practices.model.Product;
import com.example.Git_Practices.repository.CategoryRepository;
import com.example.Git_Practices.repository.ProductRepository;
import com.example.Git_Practices.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ProductResponseDTO createProduct(NewProductRequestDTO requestDTO) {
        Category category = categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        Product product = new Product();
        product.setName(requestDTO.getName());
        product.setPrice(requestDTO.getPrice());
        product.setDescription(requestDTO.getDescription());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        // Convert the saved entity to the Response DTO
        return mapToResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private ProductResponseDTO mapToResponseDTO(Product product) {
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice("$" + product.getPrice());
        response.setCategoryTitle(product.getCategory().getTitle());
        return response;
    }
}
