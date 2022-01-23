package com.univ.cardgame.service;

import com.univ.cardgame.dto.LoginUserDTO;
import com.univ.cardgame.dto.PatchUserDTO;
import com.univ.cardgame.dto.RegisterUserDTO;
import com.univ.cardgame.dto.UserDTO;
import com.univ.cardgame.entity.UserEntity;
import com.univ.cardgame.repository.UserRepository;
import com.univ.cardgame.util.JWTUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  AccountService jwtService;

  @Autowired
  JWTUtil jwtUtil;
  private UserRepository repository;

  public UserEntity register(RegisterUserDTO user) {
    Optional<UserEntity> optUser1 = userRepository.findByLogin(user.getLogin());

    return jwtService.save(user);
  }

  public String login(LoginUserDTO credentials) {

    final var userDetails = jwtService.loadUserByUsername(credentials.getLogin());
    return jwtUtil.generateToken(userDetails);
  }

  public List<UserDTO> getUserList() {
    List<UserDTO> users = new ArrayList<>();
    for (var user : userRepository.findAll()) {
      users.add(new UserDTO(user.getId(), user.getLogin(), user.getUserName(), user.getRoles()));
    }

    return users;
  }

  public UserDTO getUser(Integer userId) {
    Optional<UserEntity> user = userRepository.findById(userId);
    if (user.isEmpty()) {
      return null;
    }
    return new UserDTO(user.get().getId(), user.get().getLogin(), user.get().getUserName(),
        user.get().getRoles());
  }

  public UserDTO patchUser(PatchUserDTO userDTO, Integer userId) {
    repository = userRepository;
    Optional<UserEntity> optionalUser = repository.findById(userId);
    if (optionalUser.isEmpty()) {
      return null;
    }
    optionalUser.get().setUserName(userDTO.getFirst_name() + " " + userDTO.getLast_name());
    optionalUser.get().setLogin(userDTO.getLogin());
    optionalUser.get().setRoles(userDTO.getRoles());
    userRepository.save(optionalUser.get());
    return new UserDTO(optionalUser.get().getId(), optionalUser.get().getLogin(),
        optionalUser.get().getUserName(),
        optionalUser.get().getRoles());
  }

  public boolean deleteUser(Integer userId) {
    Optional<UserEntity> optionalUserDTO = userRepository.findById(userId);
    if (optionalUserDTO.isEmpty()) {
      return false;
    }

    userRepository.delete(optionalUserDTO.get());
    return true;
  }
}
