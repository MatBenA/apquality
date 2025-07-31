package com.matbena.apquality.service;

import com.matbena.apquality.web.dto.UserDTO;

import java.util.List;

public interface UserSecService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> findAllUsers();

    UserDTO findUserByEmail(String email);

    UserDTO updateUser(UserDTO userDTO);

    Boolean deleteUser(String email);
}
