package com.univ.cardgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultJankenDTO {
    private int computerHit;
    private String result;
}
