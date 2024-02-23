package com.doubleD.shopapp.repositories;

import com.doubleD.shopapp.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
//    Page<Product> findAll(Pageable pageable);
}
