package com.seojs.orderservice.dto;

import lombok.Data;

@Data
public class OrderRequestDto {
    private String productId;
    private Integer qty;
    private Integer unitPrice;

    private String userId;
}
