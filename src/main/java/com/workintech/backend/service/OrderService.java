package com.workintech.backend.service;

import com.workintech.backend.dto.OrderResponse;
import com.workintech.backend.entity.Order;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findAll();
    OrderResponse findById(Long id);
    OrderResponse save(Order order);

    Order findByOrderId(Long id);
}
