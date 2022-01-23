package com.univ.cardgame.dto;

import com.univ.cardgame.constante.RoleEnum;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
  private Integer id;
  private String login;
  private String userName;
  private Collection<RoleEnum> roles;
}
