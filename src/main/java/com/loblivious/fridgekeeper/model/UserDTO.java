package com.loblivious.fridgekeeper.model;

import java.util.UUID;

public record UserDTO(
    UUID id,
    String email,
    String name,
    String profilePicture) {

}
