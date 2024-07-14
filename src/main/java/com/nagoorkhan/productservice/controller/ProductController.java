package com.nagoorkhan.productservice.controller;

import com.nagoorkhan.productservice.mapper.ProductRequestMapper;
import com.nagoorkhan.productservice.mapper.ProductResponseMapper;
import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.model.request.ProductRequestVO;
import com.nagoorkhan.productservice.model.response.ProductResponseVO;
import com.nagoorkhan.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProductResponseVO> createProduct(@RequestBody ProductRequestVO productRequestVO) {
        ProductVO productVO = productRequestMapper.productRequestVOTOProductVO(productRequestVO);
        return ResponseEntity.ok(productResponseMapper.productVOTOProductResponseVO(productService.createProduct(productVO)));

    }

    @GetMapping
    public ResponseEntity<List<ProductResponseVO>> fetchAllProducts() {
        List<ProductVO> products = productService.fetchAllProducts();
        return ResponseEntity.ok(products.stream().map(productResponseMapper::productVOTOProductResponseVO).collect(Collectors.toList()));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseVO> fetchProduct(@PathVariable("productId") String productId) {
        return ResponseEntity.ok(productResponseMapper.productVOTOProductResponseVO(productService.fetchProduct(productId)));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseVO> modifyProduct(@PathVariable("productId") String productId, @RequestBody ProductRequestVO productRequestVO) {
        ProductVO productVO = productRequestMapper.productRequestVOTOProductVO(productRequestVO);
        productVO.setPid(productId);
        return ResponseEntity.ok(productResponseMapper.productVOTOProductResponseVO(productService.modifyProduct(productVO)));
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") String productId) {
        productService.deleteProduct(productId);
    }
}
