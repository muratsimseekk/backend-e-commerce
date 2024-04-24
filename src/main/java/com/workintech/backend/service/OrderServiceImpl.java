package com.workintech.backend.service;

import com.workintech.backend.dto.OrderResponse;
import com.workintech.backend.entity.Order;
import com.workintech.backend.exception.CommonException;
import com.workintech.backend.repository.OrderRepository;
import com.workintech.backend.util.OrderDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Override
    public List<OrderResponse> findAll() {
        return OrderDtoConvertion.convertOrderList(orderRepository.findAll());
    }

    @Override
    public OrderResponse findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()){
            return OrderDtoConvertion.convertOrder(order.get());
        }

        throw new CommonException("Bu id de bir siparis bulunamadi . ID : " +id , HttpStatus.NOT_FOUND);

    }
    @Override
    public OrderResponse save(Order order) {
         orderRepository.save(order);
         return OrderDtoConvertion.convertOrder(order);
    }

    @Override
    public Order findByOrderId(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()){
            return order.get();
        }

        throw new CommonException("Bu id de bir siparis bulunamadi . ID : " +id , HttpStatus.NOT_FOUND);

    }
}
