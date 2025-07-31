package com.matbena.apquality.web.dto;

import java.util.List;

public record RoleDTO(String name, List<PermissionDTO> permissionList) {
}
