package com.workintech.backend.util;

import com.workintech.backend.dto.AddressResponse;
import com.workintech.backend.dto.OrderResponse;
import com.workintech.backend.entity.Order;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDtoConvertion {

    public static List<OrderResponse> convertOrderList(List<Order> orderList) {
        List<OrderResponse> orderResponses = new ArrayList<>();

        orderList.stream().forEach(order -> orderResponses.add(new OrderResponse(order.getId(), LocalDateTime.now()
                ,order.getUser().getId() , AddressDtoConvertion.convertAddress(order.getAddress())
                , CardDtoConvertion.converCard(order.getCard()))));

        return orderResponses;
    }

    public static OrderResponse convertOrder(Order order){
        return new OrderResponse(order.getId() , LocalDateTime.now() , order.getUser().getId()
                ,AddressDtoConvertion.convertAddress(order.getAddress()),CardDtoConvertion.converCard(order.getCard()));
    }

}
