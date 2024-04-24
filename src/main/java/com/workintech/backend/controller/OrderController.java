package com.workintech.backend.controller;

import com.workintech.backend.dto.OrderResponse;
import com.workintech.backend.entity.Address;
import com.workintech.backend.entity.Card;
import com.workintech.backend.entity.Order;
import com.workintech.backend.entity.User;
import com.workintech.backend.service.AddressService;
import com.workintech.backend.service.CardService;
import com.workintech.backend.service.OrderService;
import com.workintech.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private UserService userService;
    private AddressService addressService;
    private CardService cardService;

    @GetMapping("/")
    public List<OrderResponse> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderResponse findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping("/{userID}/{addressID}/{cardID}")
    public OrderResponse save(@RequestBody Order order , @PathVariable Long userID,@PathVariable Long addressID
            , @PathVariable Long cardID){

        User user = userService.findByUserId(userID);
        Address address = addressService.findByAddressId(addressID);
        Card card = cardService.findByCardId(cardID);

        order.setAddress(address);
        order.setCard(card);

        user.getOrderList().add(order);
        order.setUser(user);

        return orderService.save(order);
    }

}
