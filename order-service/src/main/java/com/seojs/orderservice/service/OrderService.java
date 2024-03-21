package com.seojs.orderservice.service;

import com.seojs.orderservice.dto.OrderRequestDto;
import com.seojs.orderservice.dto.OrderResponseDto;
import com.seojs.orderservice.entity.Order;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
    OrderResponseDto getOrderByOrderId(String orderId);
    List<Order> getOrdersByUserId(String userId);
}
