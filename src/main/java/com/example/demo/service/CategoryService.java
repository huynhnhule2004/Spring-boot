package com.example.demo.service;

import com.example.demo.dto.response.ProductReponse;

import java.util.List;

public interface CategoryService {
    List<ProductReponse>  findProductResponseByCategoryId(Long id);
}
