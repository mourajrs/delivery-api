package com.deliverytech.delivery_api;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.deliverytech.delivery_api.dto.ProductDto;
import com.deliverytech.delivery_api.entity.Product;
import com.deliverytech.delivery_api.repository.IProductRepository;
import com.deliverytech.delivery_api.service.ProductService;
import com.deliverytech.delivery_api.service.ProductServiceImpl;

public class ProductControllerTest {
    private ProductServiceImpl productServiceImpl;
    private ProductService productService;

    @Mock
    private IProductRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(repository);
    }

    @Test
    public void should_CreateProduct() {       
        ProductDto productDto = new ProductDto("Pizza", BigDecimal.valueOf(29.90), "Comida rapida", "Pequena", "Disponivel");

        // Cria um produto simulado com ID
        Product savedProduct = new Product();
        savedProduct.setId(1L);

        // Diz ao Mockito que quando save for chamado, retorne o produto simulado
        when(repository.save(any(Product.class))).thenReturn(savedProduct);

        // Chama o método real do serviço
        Long id = productService.createProduct(productDto);

        assertTrue(id > 0);
    }
}
