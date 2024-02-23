package com.doubleD.shopapp.services;

import com.doubleD.shopapp.DTO.CategoryDTO;
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
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = Category.builder()
                            .name(categoryDTO.getName())
                            .build();
        return categoryRepo.save(newCategory);
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
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setName(categoryDTO.getName());
        categoryRepo.save(existingCategory);
        return existingCategory;
    }

    @Override
    public void deleteCategory(Long id) {
        // xoa cung
        categoryRepo.deleteById(id);
    }
}
