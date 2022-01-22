package com.univ.cardgame.dto;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String first_name;
    private String last_name;
    private String password;
    private String login;
}
