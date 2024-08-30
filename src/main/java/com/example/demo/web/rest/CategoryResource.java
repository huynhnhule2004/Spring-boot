package com.example.demo.web.rest;

import com.example.demo.dto.response.ProductReponse;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}/products")
    public List<ProductReponse> findProductResponseByCategoryId(@PathVariable Long id) {
        return categoryService.findProductResponseByCategoryId(id);
    }

    //Viết 4 APIs CRUD
}
