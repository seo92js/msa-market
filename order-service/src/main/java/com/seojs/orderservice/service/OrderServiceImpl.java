package com.seojs.orderservice.service;

import com.seojs.orderservice.dto.OrderRequestDto;
import com.seojs.orderservice.dto.OrderResponseDto;
import com.seojs.orderservice.entity.Order;
import com.seojs.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .qty(orderRequestDto.getQty())
                .productId(orderRequestDto.getProductId())
                .totalPrice(orderRequestDto.getQty() * orderRequestDto.getUnitPrice())
                .unitPrice(orderRequestDto.getUnitPrice())
                .userId(orderRequestDto.getUserId())
                .build();

        Order save = orderRepository.save(order);

        return new OrderResponseDto(save);
    }

    @Override
    public OrderResponseDto getOrderByOrderId(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);

        return new OrderResponseDto(order);
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
