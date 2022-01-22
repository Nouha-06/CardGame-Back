package com.univ.cardgame.controller;

import com.univ.cardgame.service.DeckService;
import com.univ.cardgame.util.card.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeckController {

    @GetMapping("/deck")
    public List<Card> deck() {
        DeckService deck = new DeckService();
        deck.generateCardGame();
        return deck.getPackCard();
    }
}
