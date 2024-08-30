package com.example.demo.service.impl;

import com.example.demo.dto.response.CategoryResponse;
import com.example.demo.dto.response.ProductReponse;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCategoryService implements CategoryService {

    private final CategoryRepository repository;

    private final ProductService productService;

    public DefaultCategoryService(CategoryRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    @Override
    public List<ProductReponse> findProductResponseByCategoryId(Long id) {
        Category category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with id " + id + " is not found"));
        List<Product> products = category.getProducts();
        List<ProductReponse> res = products.stream().map(p -> {
            return productService.toResponse(p);
        }).toList();

        return res;
    }
}
