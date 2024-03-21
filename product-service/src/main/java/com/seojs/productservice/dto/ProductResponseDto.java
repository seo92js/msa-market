package com.seojs.productservice.dto;

import com.seojs.productservice.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDto {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;

    public ProductResponseDto(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.unitPrice = product.getUnitPrice();
        this.stock = product.getStock();
    }
}
