package com.univ.cardgame.util.card;

public enum CardColor {
    SPADE("s"),
    HEART("h"),
    CLOVER("c"),
    DIAMOND("d");

    public final String label;

    private CardColor(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
