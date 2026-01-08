package com.example.Git_Practices.controller.dto.request;
import lombok.Data;

@Data
public class NewProductRequestDTO {
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
}
