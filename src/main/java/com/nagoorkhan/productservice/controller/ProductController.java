package com.nagoorkhan.productservice.controller;

import com.nagoorkhan.productservice.mapper.ProductRequestMapper;
import com.nagoorkhan.productservice.mapper.ProductResponseMapper;
import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.model.request.ProductRequestVO;
import com.nagoorkhan.productservice.model.response.ProductResponseVO;
import com.nagoorkhan.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRequestMapper productRequestMapper;

    private final ProductResponseMapper productResponseMapper;

    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseVO createProduct(@RequestBody ProductRequestVO productRequestVO) {
        ProductVO productVO = productRequestMapper.productRequestVOTOProductVO(productRequestVO);
        return productResponseMapper.productVOTOProductResponseVO(productService.createProduct(productVO));

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseVO> fetchAllProducts() {
        List<ProductVO> products = productService.fetchAllProducts();
        return products.stream().map(productResponseMapper::productVOTOProductResponseVO).collect(Collectors.toList());
    }
}
