package com.mateus.agregadordeinvestimentos.service;

import com.mateus.agregadordeinvestimentos.controller.CreateUserDto;
import com.mateus.agregadordeinvestimentos.entity.User;
import com.mateus.agregadordeinvestimentos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UUID createUser(CreateUserDto createUserDto) {
    var entity = new User(
      UUID.randomUUID(),
      createUserDto.username(),
      createUserDto.email(),
      createUserDto.password(),
      Instant.now(),
      null);

    var userSaved = userRepository.save(entity);

    return userSaved.getUserId();
  }

  public Optional<User> getUserById(String userId) {

    return userRepository.findById(UUID.fromString(userId));
  }

  public List<User> listUsers() {
    return userRepository.findAll();
  }

}
