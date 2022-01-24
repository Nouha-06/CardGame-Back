package com.univ.cardgame.util.card;

public class Card {
    private final CardValue value;
    private final CardColor color;
    private String picture;

    public Card(CardValue cardValue, CardColor cardColor) {
        this.value = cardValue;
        this.color = cardColor;
        this.picture = pictureValue(cardValue, cardColor);
    }

    public CardValue getValue() {
        return value;
    }

    public CardColor getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }

    public int compare(Card that) {
        return this.value.ordinal() - that.value.ordinal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        if (value != card.value) return false;
        return color == card.color;
    }

    private String pictureValue(CardValue cardValue, CardColor cardColor) {
        return cardColor.label + "-" + cardValue.label + ".svg";
    }
}
