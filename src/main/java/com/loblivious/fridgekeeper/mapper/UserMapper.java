package com.loblivious.fridgekeeper.mapper;

import com.loblivious.fridgekeeper.entity.User;
import com.loblivious.fridgekeeper.model.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
  User userDTOToUser(UserDTO userDTO);

  UserDTO userToUserDTO(User user);
}
