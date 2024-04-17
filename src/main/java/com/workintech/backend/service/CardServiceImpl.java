package com.workintech.backend.service;

import com.workintech.backend.dto.CardResponse;
import com.workintech.backend.entity.Card;
import com.workintech.backend.exception.CommonException;
import com.workintech.backend.repository.CardRepository;
import com.workintech.backend.util.CardDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService{

    private CardRepository cardRepository;

    @Override
    public List<CardResponse> findAll() {
        List<Card> cardList =cardRepository.findAll();
        return CardDtoConvertion.converCardList(cardList);
    }

    @Override
    public CardResponse findById(Long id) {
        Optional<Card> card = cardRepository.findById(id);

        if (card.isPresent()){
            return CardDtoConvertion.converCard(card.get());
        }

        throw new CommonException("Girilen id de Card bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public CardResponse save(Card card) {
         cardRepository.save(card);
         return CardDtoConvertion.converCard(card);
    }

    @Override
    public CardResponse delete(Long id) {
         cardRepository.delete(findByCardId(id));
         return findById(id);
    }

    @Override
    public Card findByCardId(Long id) {
        Optional<Card> card = cardRepository.findById(id);

        if (card.isPresent()){
            return card.get();
        }
        throw new CommonException("Girilen id de Card bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }
}
