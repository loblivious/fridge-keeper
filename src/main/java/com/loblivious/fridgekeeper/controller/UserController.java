package com.loblivious.fridgekeeper.controller;

import com.loblivious.fridgekeeper.model.UserDTO;
import com.loblivious.fridgekeeper.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;

  @GetMapping("/me/{email}")
  public ResponseEntity<UserDTO> getCurrentUser(@PathVariable("email") String email) {
    log.info("Getting current user by email {}", email);
    UserDTO user = userService.getOrCreateUser(email, "Haha", "");
    return ResponseEntity.ok(user);
  }

}
