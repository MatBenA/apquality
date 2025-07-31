package com.matbena.apquality.service;

import com.matbena.apquality.domain.model.Permission;
import com.matbena.apquality.web.dto.PermissionDTO;

import java.util.List;

public interface PermissionService {
    PermissionDTO entityToDto(Permission permission);

    PermissionDTO createPermission(PermissionDTO permissionDTO);

    List<PermissionDTO> findAllPermissions();

    PermissionDTO findPermission(String name);

    PermissionDTO updatePermission(String name, PermissionDTO permissionDTO);

    Boolean deletePermission(String name);
}