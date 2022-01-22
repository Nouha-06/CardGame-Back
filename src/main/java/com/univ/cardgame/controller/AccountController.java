package com.univ.cardgame.controller;

import com.univ.cardgame.service.UserService;
import com.univ.cardgame.dto.LoginUserDTO;
import com.univ.cardgame.dto.RegisterUserDTO;
import com.univ.cardgame.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("account")
public class AccountController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserEntity> postRegister(@RequestBody() RegisterUserDTO userDTO) {
        return ResponseEntity.ok( userService.register(userDTO));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> postAuthenticate(@RequestBody LoginUserDTO req) {
        final String token = userService.login(req);
        return ResponseEntity.ok(token);
    }

}
