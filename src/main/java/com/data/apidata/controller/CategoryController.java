package com.data.apidata.controller;

import com.data.apidata.DTOs.CategoryRequestDTO;
import com.data.apidata.DTOs.CategoryResponseDTO;
import com.data.apidata.model.Category;
import com.data.apidata.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<CategoryResponseDTO> getAll() {
        List<CategoryResponseDTO> categoryList = repository
                .findAll()
                .stream()
                .map(CategoryResponseDTO::new).toList();
        return categoryList;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createCategory (CategoryRequestDTO data) {
        Category categoryData = new Category(data);

        repository.save(categoryData);
    }
}
