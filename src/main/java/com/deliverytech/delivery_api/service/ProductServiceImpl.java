package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ProductDto;
import com.deliverytech.delivery_api.entity.Product;
import com.deliverytech.delivery_api.repository.IProductRepository;

import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
 
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private IProductRepository repository;

    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductServiceImpl() {
        super();
    }    

    @Override
    public Long createProduct(ProductDto productDto) {        
        ModelMapper modelMapper = new ModelMapper();        
        Product product = modelMapper.map(productDto, Product.class);
        return repository.save(product).getId();        
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));                
        product.setId(id);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setDisponibility(productDto.getDisponibility());
        repository.save(product);        
        return productDto;
    }

    @Override
    public void changeStatusProduct(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeStatusProduct'");
    }

    @Override
    public ProductDto findProductById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductById'");
    }

    @Override
    public List<ProductDto> findProductByCategory(String category) {        
        ModelMapper modelMapper = new ModelMapper();        
        return repository.findByCategory(category).stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findProductByRestaurant(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductByRestaurant'");
    }

    @Override
    public List<ProductDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();        
        return repository.findAll().stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }
}
