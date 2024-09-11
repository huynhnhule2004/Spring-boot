package com.example.demo.service;

import com.example.demo.dto.request.CategoryRequest;
import com.example.demo.dto.response.CategoryResponse;
import com.example.demo.dto.response.ProductReponse;
import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<ProductReponse>  findProductResponseByCategoryId(Long id);

    CategoryResponse create(CategoryRequest request);

    CategoryResponse toResponse(Category saveCategory);

    CategoryResponse findById(Long id);

    CategoryResponse updateById(Long id, CategoryRequest request);

    void deleteById(Long id);
}
