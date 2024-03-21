package com.seojs.orderservice.dto;

import com.seojs.orderservice.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDto {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private String orderId;

    public OrderResponseDto(Order order) {
        this.productId = order.getProductId();
        this.qty = order.getQty();
        this.unitPrice = order.getUnitPrice();
        this.totalPrice = order.getTotalPrice();
        this.orderId = order.getOrderId();
    }
}
