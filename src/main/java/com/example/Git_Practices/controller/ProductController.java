package com.example.Git_Practices.controller;
import com.example.Git_Practices.controller.dto.request.NewProductRequestDTO;
import com.example.Git_Practices.controller.dto.response.ProductResponseDTO;
import com.example.Git_Practices.model.Product;
import com.example.Git_Practices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody NewProductRequestDTO requestDTO) {
        ProductResponseDTO response = productService.createProduct(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        // Returning the DTO list for a clean API response
        return ResponseEntity.ok(productService.getAllProducts());
    }
}