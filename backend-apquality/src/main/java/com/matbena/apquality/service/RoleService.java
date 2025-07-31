package com.matbena.apquality.service;

import com.matbena.apquality.domain.model.Role;
import com.matbena.apquality.web.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO entityToDto(Role role);

    RoleDTO createRole(RoleDTO roleDTO);

    List<RoleDTO> findAllRoles(RoleDTO roleDTO);

    RoleDTO findRole(String name);

    RoleDTO updateRole(String name, RoleDTO roleDTO);

    Boolean deleteRole(String name);
}
