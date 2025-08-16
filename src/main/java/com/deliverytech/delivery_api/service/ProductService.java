package com.deliverytech.delivery_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ProductDto;

@Service
public interface ProductService {
    public Long createProduct(ProductDto productDto);

    public ProductDto updateProduct(ProductDto productDto, Long id);

    public void changeStatusProduct(Long id);

    public ProductDto findProductById(Long id);

    public List<ProductDto> findProductByCategory(String category);

    public List<ProductDto> findProductByRestaurant(String name);

    public List<ProductDto> findAll();    
}
