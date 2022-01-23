package com.univ.cardgame.service;


import com.univ.cardgame.repository.UserRepository;
import com.univ.cardgame.util.JWTUtil;
import com.univ.cardgame.dto.RegisterUserDTO;
import com.univ.cardgame.constante.RoleEnum;
import com.univ.cardgame.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        Optional<UserEntity> optUser = userRepository.findByLogin(login);
        if (optUser.isEmpty())
            throw new UsernameNotFoundException("User not found with login: " + login);

        List<GrantedAuthority> roles = new ArrayList<>();
        for (RoleEnum role : optUser.get().getRoles())
            roles.add(new SimpleGrantedAuthority(role.name()));

        return new User(optUser.get().getLogin(), optUser.get().getPassword(), roles);
    }

    public UserEntity save(RegisterUserDTO userDTO) {
        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setLogin(userDTO.getLogin());
        newUserEntity.setPassword(userDTO.getPassword());
        newUserEntity.setUserName(userDTO.getFirst_name() + userDTO.getLast_name());
        List<RoleEnum> roles = new ArrayList<>();
        roles.add(RoleEnum.ROLE_PLAYER);

        newUserEntity.setRoles(roles);
        newUserEntity.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        return userRepository.save(newUserEntity);
    }

    public Collection<RoleEnum> getRolesByToken(String token) {
        String payload = jwtUtil.getRolesFromToken(token);
        Collection<RoleEnum> roles = new ArrayList<>();
        if (!payload.isEmpty())
            for (String role : payload.split(","))
                roles.add(RoleEnum.valueOf(role));

        return roles;
    }

}
