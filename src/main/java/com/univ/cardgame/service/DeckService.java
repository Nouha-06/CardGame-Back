package com.univ.cardgame.service;

import com.univ.cardgame.util.card.Card;
import com.univ.cardgame.util.card.CardColor;
import com.univ.cardgame.util.card.CardValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckService {
    private final List<Card> packCard;

    public DeckService() {
        packCard = new ArrayList<>();
    }

    public void generateCardGame() {
        generateDeck();
        shuffle();
    }

    public Card pick() {
        var card = packCard.get(0);
        packCard.remove(0);
        return card;
    }

    public void put(Card c1) {
        packCard.add(c1);
    }

    public List<Card> getPackCard() {
        return packCard;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "packCard=" + packCard +
                '}';
    }

    private void shuffle() {
        Collections.shuffle(packCard, new Random());
    }

    private void generateDeck() {
        for(CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                this.packCard.add(new Card(value,color));
            }
        }
    }


}
