package com.mateus.agregadordeinvestimentos.controller;

import com.mateus.agregadordeinvestimentos.entity.User;
import com.mateus.agregadordeinvestimentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
    var userId = userService.createUser(createUserDto);

    return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
  }


}
