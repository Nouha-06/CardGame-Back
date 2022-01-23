package com.univ.cardgame.controller;

import com.univ.cardgame.dto.PatchUserDTO;
import com.univ.cardgame.dto.UserDTO;
import com.univ.cardgame.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping(value = "/users")
  public ResponseEntity<List<UserDTO>> getUsers() {
    return ResponseEntity.ok(userService.getUserList());
  }

  @GetMapping(value = "/users/{id}")
  public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.getUser(id));
  }

  @PatchMapping(value = "/users/{id}")
  public ResponseEntity<UserDTO> patchUser(@PathVariable Integer id,
      @RequestBody() PatchUserDTO userDTO
  ) {
    return ResponseEntity.ok(userService.patchUser(userDTO, id));
  }

  @DeleteMapping(value = "/users/{id}")
  public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.deleteUser(id));
  }
}
