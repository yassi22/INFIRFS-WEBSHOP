package com.example.codealongw3.dao;

import com.example.codealongw3.dto.CategoryDTO;
import com.example.codealongw3.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDao {

    private final CategoryRepository categoryRepository;

    public CategoryDao(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return this.categoryRepository.findAll();
    }

    public void createCategory(CategoryDTO categoryDTO){
        Category category = new Category(categoryDTO.name);
        this.categoryRepository.save(category);
    }





}
