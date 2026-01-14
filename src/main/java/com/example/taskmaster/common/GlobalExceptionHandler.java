package com.example.taskmaster.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler.
 * Catches all exceptions thrown in Controllers and wraps them in Result.error().
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        e.printStackTrace(); // Log it for us
        return Result.error("System Error: " + e.getMessage());
    }
}
