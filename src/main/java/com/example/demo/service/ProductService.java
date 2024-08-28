package com.example.demo.service;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ProductReponse;

public interface ProductService {

    ProductReponse create(ProductRequest request);

    ProductReponse findById(Long id);

    void deleteById(Long id);

    ProductReponse updateById(Long id, ProductRequest request);
}
