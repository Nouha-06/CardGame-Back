package com.univ.cardgame.dto;

import com.univ.cardgame.util.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResultBattleDTO {
    private List<Card>[] decks;
    private String winner;
    private Integer[] roundResult;
}
