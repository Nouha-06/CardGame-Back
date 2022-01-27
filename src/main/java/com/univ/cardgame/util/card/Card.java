package com.univ.cardgame.util.card;

public class Card {
    private final CardValue value;
    private final CardColor color;
    private final String label;

    public Card(CardValue cardValue, CardColor cardColor) {
        this.value = cardValue;
        this.color = cardColor;
        this.label = cardColor.getLabel() + "-" + cardValue.getLabel();
    }

    public CardValue getValue() {
        return value;
    }

    public CardColor getColor() {
        return color;
    }

    public String getLabel() { return label; }


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
}
