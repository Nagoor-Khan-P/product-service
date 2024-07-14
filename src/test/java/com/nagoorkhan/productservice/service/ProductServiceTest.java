package com.nagoorkhan.productservice.service;

import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    @Test
    void testCreateProduct() {
        when(productRepository.insert(any(ProductVO.class))).thenReturn(createProductVO());
        ProductVO productVO = productService.createProduct(new ProductVO("Laptop", new BigDecimal("20000.23"), "Apple Macbook M3"));

        assertEquals("1", productVO.getPid());


    }

    private ProductVO createProductVO() {
        return new ProductVO("1", "Laptop", new BigDecimal("20000.23"), "Apple Macbook M3");
    }

}
