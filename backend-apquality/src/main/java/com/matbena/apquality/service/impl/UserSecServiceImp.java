package com.matbena.apquality.service.impl;

import com.matbena.apquality.domain.model.Role;
import com.matbena.apquality.domain.model.UserSec;
import com.matbena.apquality.domain.repository.RoleRepository;
import com.matbena.apquality.domain.repository.UserSecRepository;
import com.matbena.apquality.service.RoleService;
import com.matbena.apquality.service.UserSecService;
import com.matbena.apquality.web.dto.RoleDTO;
import com.matbena.apquality.web.dto.SelectOptionDTO;
import com.matbena.apquality.web.dto.UserDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserSecServiceImp implements UserSecService {

    private final UserSecRepository userSecRepository;
    private final RoleRepository roleRepository;

    private final RoleService roleService;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserSec user = new UserSec();

        Role role = roleRepository.findByName(userDTO.role().name())
                .orElseThrow(() -> new EntityNotFoundException("Role not found for name: " + userDTO.role().name()));

        user.setFirstName(userDTO.firstname());
        user.setLastname(userDTO.lastName());
        user.setEmail(userDTO.email());
        user.setRole(role);

        return entityToDto(userSecRepository.save(user));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userSecRepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return entityToDto(userSecRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found for email: " + email)));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean deleteUser(String email) {
        return null;
    }

    public SelectOptionDTO userToOptionDTO(UserSec userSec){
        return new SelectOptionDTO(
                userSec.getEmail(),
                userSec.getFullName()
        );
    }

    public UserDTO entityToDto (UserSec userSec){

        RoleDTO roleDto = roleService.entityToDto(userSec.getRole());

        return new UserDTO(
                userSec.getFirstName(),
                userSec.getLastname(),
                userSec.getEmail(),
                userSec.getIsAvailable(),
                roleDto);
    }
}