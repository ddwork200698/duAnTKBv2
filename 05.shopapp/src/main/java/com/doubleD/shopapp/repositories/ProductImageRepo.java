package com.doubleD.shopapp.repositories;

import com.doubleD.shopapp.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepo extends JpaRepository<ProductImage, Long> {
    List<ProductImage> findByProductId(Long id);
}
