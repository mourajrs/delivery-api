package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.ProductDto;
import com.deliverytech.delivery_api.service.ProductService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createProduct(@Valid @RequestBody ProductDto dto) {
        Long id = productService.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PatchMapping("/{id}/product")
    public ResponseEntity<ProductDto> updateProduto(Long id, @RequestBody  ProductDto dto) {
        ProductDto productDto = productService.updateProduct(dto, id);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/byCategory")
    public ResponseEntity<List<ProductDto>> findProductByCategory(@RequestParam("query") String category) {
        List<ProductDto> productDto = productService.findProductByCategory(category);
        return ResponseEntity.ok(productDto);
    }
}
