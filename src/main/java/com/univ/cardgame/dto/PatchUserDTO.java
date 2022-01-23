package com.univ.cardgame.dto;

import com.univ.cardgame.constante.RoleEnum;
import java.util.Collection;
import lombok.Data;

@Data
public class PatchUserDTO {
  private String first_name;
  private String last_name;
  private String login;
  private Collection<RoleEnum> roles;
}
