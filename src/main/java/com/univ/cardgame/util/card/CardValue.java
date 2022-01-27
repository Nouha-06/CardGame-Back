package com.univ.cardgame.util.card;

public enum CardValue {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("j"),
    QUEEN("q"),
    KING("k"),
    AS("a");

    private final String label;

    CardValue(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
