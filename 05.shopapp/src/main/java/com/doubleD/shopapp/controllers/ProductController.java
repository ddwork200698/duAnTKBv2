package com.doubleD.shopapp.controllers;

import com.doubleD.shopapp.models.Categories;
import com.doubleD.shopapp.models.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    // Hien thi tat ca products
    // http://localhost:8088/api/v1/products?page=1&limit=10
    @GetMapping("")
    public ResponseEntity<String> getAllProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok(String.format("getAllProducts, page = %d, limit = %d", page, limit));
    }
    //Get product by Id
    // http://localhost:8088/api/v1/products/1
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable Long id){
        return ResponseEntity.ok("get Product with id: " + id);
    }
    // Delete product by id
    // http://localhost:8088/api/v1/products/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        return ResponseEntity.ok("delete Product with id: " + id);
    }
    // Upload product
    // http://localhost:8088/api/v1/products
    @PostMapping(value = "",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> insertProduct(
            @Valid @RequestBody Product product,
            @RequestPart("file") MultipartFile file,
            BindingResult result
    ){
        if(result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        if(file.getSize() >=10 * 1024 * 1024){
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File qua lon");
        }
        return ResponseEntity.ok("inset Product: " + product);
    }
}
