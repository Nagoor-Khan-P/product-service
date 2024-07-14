package com.nagoorkhan.productservice.service;

import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;

    public ProductVO createProduct(ProductVO productVO) {
        productVO = productRepository.save(productVO);
        log.info("Product is created successfully with id {}", productVO.getPid());
        return productVO;
    }

    public List<ProductVO> fetchAllProducts() {
        return productRepository.findAll();
    }
}
