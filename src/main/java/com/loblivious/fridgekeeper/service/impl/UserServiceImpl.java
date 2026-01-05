package com.loblivious.fridgekeeper.service.impl;

import com.loblivious.fridgekeeper.entity.User;
import com.loblivious.fridgekeeper.mapper.UserMapper;
import com.loblivious.fridgekeeper.model.UserDTO;
import com.loblivious.fridgekeeper.repository.UserRepository;
import com.loblivious.fridgekeeper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  @Transactional
  public UserDTO getOrCreateUser(String email, String name, String profilePicture) {
    User user = userRepository.findByEmail(email)
        .map(u -> {
          // update info if changed
          boolean changed = false;
          if (name != null && !name.equals(u.getName())) {
            u.setName(name);
            changed = true;
          }
          if (profilePicture != null && !profilePicture.equals(u.getProfilePicture())) {
            u.setProfilePicture(profilePicture);
            changed = true;
          }
          return changed ? userRepository.save(u) : u;
        })
        .orElseGet(() -> userRepository.save(User.builder()
            .email(email)
            .name(StringUtils.hasLength(name) ? name : "Stranger")
            .profilePicture(profilePicture)
            .build()));
    return userMapper.userToUserDTO(user);
  }

  @Override
  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User not found: " + email));
  }
}
