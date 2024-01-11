package com.doubleD.shopapp.repositories;

import com.doubleD.shopapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
