package com.doubleD.shopapp.controllers;

import com.doubleD.shopapp.DTO.ProductDTO;
import com.doubleD.shopapp.DTO.ProductImagesDTO;
import com.doubleD.shopapp.models.Product;
import com.doubleD.shopapp.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;
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
            @Valid @ModelAttribute ProductDTO productDTO,
            // @RequestPart("file") MultipartFile file,
             BindingResult result
    ){
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            Product newProduct = productService.createProduct(productDTO);
            List<MultipartFile> files = productDTO.getFiles();
            // Kiểm tra file upload có phải là null ko ?
            files = files == null ? new ArrayList<MultipartFile>() : files;
            String fileName = "";
            for(MultipartFile file : files){
                if (file.getSize() == 0){
                    continue;
                }
                if (file.getSize() >= 10 * 1024 * 1024) {
                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File qua lon");
                }
                // Kiem tra dinh dang file
                String contentType = file.getContentType();
                if (contentType == null || !contentType.startsWith("image/")) {
                    return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("File must be image");
                }
                // Lưu file và lấy uniqueFilename
                String uniqueFilename = storeFile(file);
                // Lưu đối tượng vào CSDL
                productService.createProductImages(
                        newProduct.getId(),
                        ProductImagesDTO.builder()
                                .productID(newProduct.getId())
                                .url(uniqueFilename)
                                .build()
                );
            }
            return ResponseEntity.ok("inset Product thanh cong");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/yourEndpoint")
    public ResponseEntity<?> yourMethod() {
        // Xử lý yêu cầu
        return ResponseEntity.ok("Success");
    }
    private String storeFile(MultipartFile file) throws IOException {
        if (!isImageFile(file) || file.getOriginalFilename() == null) {
            throw new IOException("Invalid image format");
        }
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        // Thêm UUID vào trước tên file để đảm bảo tên file là duy nhất
        String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;
        // Đường dẫn đến thư mục mà bạn muốn lưu file
        java.nio.file.Path uploadDir = Paths.get("uploads");
        // Kiểm tra và tạo thư mục nếu nó không tồn tại
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        // Đường dẫn đầy đủ đến file
        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFilename);
        // Sao chép file vào thư mục đích
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
    }
    private boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/");
    }
}
