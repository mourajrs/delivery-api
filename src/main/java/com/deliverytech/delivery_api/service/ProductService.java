package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ProductDto;
import com.deliverytech.delivery_api.entity.Product;
import com.deliverytech.delivery_api.repository.IProductRepository;

@Service
public class ProductService {
    @Autowired
    private IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductService() {
        super();
    }
    public List<ProductDto> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDto).collect(Collectors.toList());
    }

    private ProductDto ConvertEntityToDto(Product entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCategory(entity.getCategory());
        dto.setDescription(entity.getDescription());
        dto.setDisponibility(entity.getDisponibility());
        return dto;
    }
}
