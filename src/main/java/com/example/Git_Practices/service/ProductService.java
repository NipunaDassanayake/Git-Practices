package com.example.Git_Practices.service;


import com.example.Git_Practices.controller.dto.request.NewProductRequestDTO;
import com.example.Git_Practices.controller.dto.response.ProductResponseDTO;
import com.example.Git_Practices.model.Product;

import java.util.List;

public interface ProductService {
    public ProductResponseDTO createProduct(NewProductRequestDTO requestDTO);
    public List<ProductResponseDTO> getAllProducts();
}