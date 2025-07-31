package com.matbena.apquality.service.impl;

import com.matbena.apquality.domain.model.Permission;
import com.matbena.apquality.domain.model.Role;
import com.matbena.apquality.domain.repository.PermissionRepository;
import com.matbena.apquality.domain.repository.RoleRepository;
import com.matbena.apquality.service.PermissionService;
import com.matbena.apquality.service.RoleService;
import com.matbena.apquality.web.dto.PermissionDTO;
import com.matbena.apquality.web.dto.RoleDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    private final PermissionService permissionService;

    @Override
    public RoleDTO entityToDto(Role role){
        List<PermissionDTO> permissionDTOList = role.getPermissionList().stream()
                .map(permissionService::entityToDto)
                .toList();
        return new RoleDTO(role.getName(), permissionDTOList);
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {

        List<Permission> permissionList = roleDTO.permissionList()
                .stream()
                .map(permissionDTO -> permissionRepository.findByName(permissionDTO.name())
                        .orElseThrow(() -> new EntityNotFoundException("Permission not found for name: " + permissionDTO.name())))
                .toList();

        Role role = new Role();
        role.setName(roleDTO.name());
        role.setPermissionList(permissionList);

        return entityToDto(roleRepository.save(role));
    }

    @Override
    public List<RoleDTO> findAllRoles(RoleDTO roleDTO) {
        return roleRepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public RoleDTO findRole(String name) {
        return entityToDto(roleRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found for name: " + name)));
    }

    @Override
    public RoleDTO updateRole(String name, RoleDTO roleDTO) {

        List<Permission> permissionList = roleDTO.permissionList()
                .stream()
                .map(permissionDTO -> permissionRepository.findByName(permissionDTO.name())
                        .orElseThrow(() -> new EntityNotFoundException("Permission not found for name: " + permissionDTO.name())))
                .toList();

        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found for name: " + name));

        role.setName(roleDTO.name());
        role.setPermissionList(permissionList);

        return entityToDto(roleRepository.save(role));
    }

    @Override
    public Boolean deleteRole(String name) {
        try {
            if(!roleRepository.existsByName(name)){
                return false;
            } else {
                roleRepository.deleteByName(name);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
