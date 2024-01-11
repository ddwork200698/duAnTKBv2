package com.doubleD.shopapp.services;

import com.doubleD.shopapp.models.Category;
import com.doubleD.shopapp.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName());
        return existingCategory;
    }

    @Override
    public void deleteCategory(Long id) {
        // xoa cung
        categoryRepo.deleteById(id);
    }
}
