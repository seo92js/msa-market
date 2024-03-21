package com.seojs.productservice.controller;

import com.seojs.productservice.dto.ProductResponseDto;
import com.seojs.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product-service")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final Environment env;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Product service on Port %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        List<ProductResponseDto> products = productService.getAllProducts().stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
