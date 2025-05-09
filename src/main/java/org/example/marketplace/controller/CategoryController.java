package org.example.marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Category;
import org.example.marketplace.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable long id) {
        categoryService.deleteCategoryById(id);
    }
}

