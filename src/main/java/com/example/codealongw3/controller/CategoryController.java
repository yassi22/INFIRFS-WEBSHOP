package com.example.codealongw3.controller;


import com.example.codealongw3.dao.CategoryDao;
import com.example.codealongw3.dto.CategoryDTO;
import com.example.codealongw3.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryDao.getAllCategory());
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO){
        this.categoryDao.createCategory(categoryDTO);
        return ResponseEntity.ok("Created a task" + categoryDTO.name);
    }



}
