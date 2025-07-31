package com.matbena.apquality.web.dto;

import java.util.List;

public record UserDTO(String firstname,
                      String lastName,
                      String email,
                      Boolean isAvailable,
                      RoleDTO role) {
}