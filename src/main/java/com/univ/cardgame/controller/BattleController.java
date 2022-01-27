package com.univ.cardgame.controller;

import com.univ.cardgame.dto.ResultBattleDTO;
import com.univ.cardgame.service.BattleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BattleController {

    @GetMapping(value = "/battle/play/{roundNumber}")
    public ResultBattleDTO play(@PathVariable Integer roundNumber) {
        return BattleService.play(roundNumber);
    }
}
