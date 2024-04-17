package com.workintech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "card" , schema = "ecommercebackend")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId ;


    private Long cardNo;
    private Long cardExpireMonth;
    private Long cardExpireYear;
    private Long cardCcv;
    private Long cardName;
}
