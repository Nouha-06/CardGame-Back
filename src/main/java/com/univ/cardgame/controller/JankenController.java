package com.univ.cardgame.controller;


import com.univ.cardgame.dto.ResultJankenDTO;
import com.univ.cardgame.service.JankenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JankenController {

    @GetMapping(value = "/janken/play/{hit}")
    public ResultJankenDTO play(@PathVariable Integer hit) {
        return JankenService.play(hit);
    }
}
