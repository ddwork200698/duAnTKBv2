package com.doubleD.shopapp.services;

import com.doubleD.shopapp.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategory();
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
