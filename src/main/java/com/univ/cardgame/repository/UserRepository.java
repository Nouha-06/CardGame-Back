package com.univ.cardgame.repository;

import com.univ.cardgame.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByLogin(String login);
}