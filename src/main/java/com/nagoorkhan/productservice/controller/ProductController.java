package com.nagoorkhan.productservice.controller;

import com.nagoorkhan.productservice.mapper.ProductRequestMapper;
import com.nagoorkhan.productservice.mapper.ProductResponseMapper;
import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.model.request.ProductRequestVO;
import com.nagoorkhan.productservice.model.response.ProductResponseVO;
import com.nagoorkhan.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRequestMapper productRequestMapper;

    private final ProductResponseMapper productResponseMapper;

    private final ProductService productService;


    @PostMapping
    public ProductResponseVO createProduct(@RequestBody ProductRequestVO productRequestVO) {
        ProductVO productVO = productRequestMapper.productRequestVOTOProductVO(productRequestVO);
        return productResponseMapper.productVOTOProductResponseVO(productService.createProduct(productVO));

    }
}
