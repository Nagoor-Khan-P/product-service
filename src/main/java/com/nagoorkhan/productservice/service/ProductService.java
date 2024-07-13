package com.nagoorkhan.productservice.service;

import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public ProductVO createProduct(ProductVO productVO) {
        return productRepository.save(productVO);
    }
}
