package com.doubleD.shopapp.controllers;

import com.doubleD.shopapp.models.Categories;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.stream;

//@Validated
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    // Hien thi tat ca categories
    // http://localhost:8088/api/v1/categories?page=1&limit=10
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok(String.format("getAllCategories, page = %d, limit = %d", page, limit));
    }
    // Neu tham so truyen vao la dang doi tuong => Data Transfer Object = Request Object
    @PostMapping("")
    public ResponseEntity<?> insertCategory(
            @Valid  @RequestBody Categories category,
            BindingResult result
    ){
        if(result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("insetCategory: " + category);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id){
        return ResponseEntity.ok("updateCategory with id: " + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        return ResponseEntity.ok("deleteCategory with id: " + id);
    }
}
