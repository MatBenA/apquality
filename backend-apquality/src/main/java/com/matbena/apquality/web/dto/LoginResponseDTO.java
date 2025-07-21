package com.matbena.apquality.web.dto;

import java.util.List;

public record LoginResponseDTO(String email,
                               String token,
                               String role,
                               List<String> permissionList) {
}
