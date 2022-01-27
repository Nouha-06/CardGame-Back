package com.univ.cardgame.service;

import com.univ.cardgame.dto.ResultBattleDTO;
import java.util.List;
import java.util.stream.Collectors;

public class BattleService {

    public static ResultBattleDTO play(int round) {
        var deckService = new DeckService();
        deckService.generateCardGame();
        var cardUsed = deckService.getPackCard().stream().limit(round * 2L).collect(Collectors.toList());
        var playerCard = cardUsed.stream().limit(round).collect(Collectors.toList());
        var computerCard = cardUsed.stream().skip(round).limit(round).collect(Collectors.toList());
        var deck = new List[]{playerCard, computerCard};

        var scorePlayer = 0;
        var scoreComputer = 0;
        var valueCardOfGame = new Integer[] {2,3,4,5,6,7,8,9,10,11,12,13,14};
        var roundResult = new Integer[round];
        for (int i = 0; playerCard.size() > i; i++) {
            if (playerCard.get(i).getValue() == computerCard.get(i).getValue()) {
              break;
            } else if(valueCardOfGame[playerCard.get(i).getValue().ordinal()] >
                    valueCardOfGame[computerCard.get(i).getValue().ordinal()]) {
                scorePlayer++;
                roundResult[i] = 1;
            } else {
                scoreComputer++;
                roundResult[i] = 2;
            }
        }
        var winner = "ERROR";
        if (scoreComputer > scorePlayer) {
            winner = "COMPUTER";
        } else if (scorePlayer > scoreComputer) {
            winner = "PLAYER";
        } else {
            winner = "DRAW";
        }
        return new ResultBattleDTO(deck, winner, roundResult);
    }

}
