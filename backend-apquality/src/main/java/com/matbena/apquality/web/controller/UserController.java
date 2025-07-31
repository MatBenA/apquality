package com.matbena.apquality.web.controller;

import com.matbena.apquality.service.UserSecService;
import com.matbena.apquality.web.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserSecService userSecService;

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userSecService.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userSecService.findAllUsers();
    }

    @GetMapping("/{email}")
    public UserDTO findUserByEmail(@PathVariable String email) {
        return userSecService.findUserByEmail(email);
    }

    @PutMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userSecService.updateUser(userDTO);
    }

    @DeleteMapping("/delete/{email}")
    public Boolean deleteUser(@PathVariable String email){
        return userSecService.deleteUser(email);
    }
}
