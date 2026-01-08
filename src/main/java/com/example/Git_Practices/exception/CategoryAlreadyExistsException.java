package com.example.Git_Practices.exception;

public class CategoryAlreadyExistsException extends BusinessException {
    public CategoryAlreadyExistsException(String title) {
        super("Category with title '" + title + "' already exists.");
    }
}