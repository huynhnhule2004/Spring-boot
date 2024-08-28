package com.example.demo.service.impl;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ProductReponse;
import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository repository;

    public DefaultProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductReponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDesc(request.getDesc());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());

        //save xuoong database
       Product saveProduct = repository.save(product);

       ProductReponse reponse = new ProductReponse();
        reponse.setId(saveProduct.getId());
        reponse.setName(saveProduct.getName());
        reponse.setDesc(saveProduct.getDesc());
        reponse.setQuantity(saveProduct.getQuantity());
        reponse.setPrice(saveProduct.getPrice());
        return reponse;
    }

    @Override
    public ProductReponse findById(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + "is not found"));
        ProductReponse reponse = new ProductReponse();
        reponse.setId(product.getId());
        reponse.setName(product.getName());
        reponse.setDesc(product.getDesc());
        reponse.setQuantity(product.getQuantity());
        reponse.setPrice(product.getPrice());
        return reponse;
    }

    @Override
    public void deleteById(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + "is not found"));
        repository.delete(product);
    }

    @Override
    public ProductReponse updateById(Long id, ProductRequest request) {
        // Kiểm tra xem sản phẩm có tồn tại hay không
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " is not found"));

        // Cập nhật thông tin sản phẩm với dữ liệu từ request
        product.setName(request.getName());
        product.setDesc(request.getDesc());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());

        // Lưu sản phẩm đã cập nhật vào cơ sở dữ liệu
        Product updatedProduct = repository.save(product);

        // Tạo đối tượng ProductReponse từ sản phẩm đã cập nhật
        ProductReponse reponse = new ProductReponse();
        reponse.setId(updatedProduct.getId());
        reponse.setName(updatedProduct.getName());
        reponse.setDesc(updatedProduct.getDesc());
        reponse.setQuantity(updatedProduct.getQuantity());
        reponse.setPrice(updatedProduct.getPrice());

        return reponse;
    }
}
