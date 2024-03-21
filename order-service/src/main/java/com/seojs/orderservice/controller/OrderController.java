package com.seojs.orderservice.controller;

import com.seojs.orderservice.dto.OrderRequestDto;
import com.seojs.orderservice.dto.OrderResponseDto;
import com.seojs.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service")
public class OrderController {
    private final OrderService orderService;
    private final Environment env;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Order service on Port %s", env.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrderResponseDto> createOrder(@PathVariable(name = "userId") String userId, @RequestBody OrderRequestDto orderRequestDto) {
        orderRequestDto.setUserId(userId);

        OrderResponseDto orderResponseDto = orderService.createOrder(orderRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrderResponseDto>> getOrders(@PathVariable(name = "userId") String userId) {
        List<OrderResponseDto> users = orderService.getOrdersByUserId(userId).stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
