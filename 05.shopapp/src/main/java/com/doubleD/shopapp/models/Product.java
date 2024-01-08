package com.doubleD.shopapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "products")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Long id;
    @Size(min=3, max= 200, message="Độ dài từ 3 đến 200 ký tự")
    private String name;
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    @Max(value = 100000000, message = "Price must be less than r equal to 10.000.000")
    private Float price;
    private String url;
    private String description;
    @JsonProperty("category_id")
    private Long categoryId;
    private List<MultipartFile> files;
}