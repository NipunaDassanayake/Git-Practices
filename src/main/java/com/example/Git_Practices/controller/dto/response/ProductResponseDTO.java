package com.example.Git_Practices.controller.dto.response;
import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String price;
    private String categoryTitle;
}
