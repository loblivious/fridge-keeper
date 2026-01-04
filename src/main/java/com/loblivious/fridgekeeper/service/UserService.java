package com.loblivious.fridgekeeper.service;

import com.loblivious.fridgekeeper.model.UserDTO;

public interface UserService {
  UserDTO getOrCreateUser(String email, String name, String profilePicture);
}
