package com.univ.cardgame.service;

import com.univ.cardgame.dto.ResultJankenDTO;
import com.univ.cardgame.util.RandomInt;

public class JankenService {

    public static ResultJankenDTO play(int userHit) {
        var computerHit = RandomInt.rand(0,2);
        var winner = "error";
        if (((userHit - computerHit) == -1) || ((userHit - computerHit) == 2)) {
            winner = "PLAYER";
        } else if (((userHit - computerHit) == 1) || ((userHit - computerHit) == -2)) {
            winner = "COMPUTER";
        } else if (userHit == computerHit) {
            winner = "DRAW";
        }
        return new ResultJankenDTO(computerHit, winner);
    }
}
