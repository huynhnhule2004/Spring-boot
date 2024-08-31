package com.example.demo.service.impl;

import com.example.demo.dto.request.CategoryRequest;
import com.example.demo.dto.request.ProductRequest;
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

    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());

        //save xuoong database
        Category saveCategory = repository.save(category);

        CategoryResponse response = toResponse(saveCategory);

        return response;
    }

    @Override
    public CategoryResponse toResponse(Category saveCategory) {
        CategoryResponse response = new CategoryResponse();
        response.setId(saveCategory.getId());
        response.setName(saveCategory.getName());

        return response;
    }

    @Override
    public CategoryResponse findById(Long id) {
        Category category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with id " + id + "is not found"));
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }


    @Override
    public void deleteById(Long id) {
        Category category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with id " + id + "is not found"));
        repository.delete(category);
    }

    @Override
    public CategoryResponse updateById(Long id, CategoryRequest request) {
        // Kiểm tra xem sản phẩm có tồn tại hay không
        Category category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id " + id + " is not found"));

        // Cập nhật thông tin sản phẩm với dữ liệu từ request
        category.setName(request.getName());

        // Lưu sản phẩm đã cập nhật vào cơ sở dữ liệu
        Category updatedCategory = repository.save(category);

        // Tạo đối tượng CategoryResponse từ sản phẩm đã cập nhật
        CategoryResponse response = new CategoryResponse();
        response.setId(updatedCategory.getId());
        response.setName(updatedCategory.getName());

        return response;
    }
}
