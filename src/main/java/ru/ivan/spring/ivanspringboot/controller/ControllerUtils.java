package ru.ivan.spring.ivanspringboot.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class ControllerUtils {
    static Map<String, String> getErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField() + "Error", fieldError.getDefaultMessage());
            }
        }
        return errors;
    }
}
