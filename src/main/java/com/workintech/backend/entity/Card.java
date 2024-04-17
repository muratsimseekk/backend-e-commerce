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

    @Column(name = "card_no")
    private Long cardNo;

    @Column(name = "card_expire_month")
    private Long cardExpireMonth;

    @Column(name = "card_expire_year")
    private Long cardExpireYear;

    @Column(name = "card_ccv")
    private Long cardCcv;

    @Column(name = "card_name")
    private Long cardName;
}
