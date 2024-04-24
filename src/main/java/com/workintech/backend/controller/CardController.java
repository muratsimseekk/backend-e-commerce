package com.workintech.backend.controller;

import com.workintech.backend.dto.CardResponse;
import com.workintech.backend.entity.Card;
import com.workintech.backend.entity.User;
import com.workintech.backend.service.CardService;
import com.workintech.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@AllArgsConstructor
public class CardController {

    private CardService cardService;
    private UserService userService;

    @GetMapping("/")
    public List<CardResponse> findAll(){
        return cardService.findAll();
    }

    @GetMapping("/{id}")
    public CardResponse findById(@PathVariable Long id){
        return cardService.findById(id);
    }

    @PostMapping("/{userID}")
    public CardResponse save(@RequestBody Card card , @PathVariable Long userID){

        User user = userService.findByUserId(userID);

        card.setUser(user);

        user.getCardList().add(card);

        return cardService.save(card);
    }

    @DeleteMapping("/{id}")
    public CardResponse delete(@PathVariable Long id){
        return cardService.delete(id);
    }
}
