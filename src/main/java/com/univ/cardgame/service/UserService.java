package com.univ.cardgame.service;

import com.univ.cardgame.repository.UserRepository;
import com.univ.cardgame.util.JWTUtil;
import com.univ.cardgame.dto.LoginUserDTO;
import com.univ.cardgame.dto.RegisterUserDTO;
import com.univ.cardgame.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountService jwtService;

    @Autowired
    JWTUtil jwtUtil;

    public UserEntity register(RegisterUserDTO user)  {
        Optional<UserEntity> optUser1 = userRepository.findByLogin(user.getLogin());

        return jwtService.save(user);
    }

    public String login(LoginUserDTO credentials) {

        final var userDetails = jwtService.loadUserByUsername(credentials.getLogin());
        return jwtUtil.generateToken(userDetails);
    }
}
