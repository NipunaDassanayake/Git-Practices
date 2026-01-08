package com.example.Git_Practices.exception;

// Base exception for all business logic errors
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}