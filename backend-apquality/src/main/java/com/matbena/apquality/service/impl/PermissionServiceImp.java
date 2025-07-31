package com.matbena.apquality.service.impl;

import com.matbena.apquality.domain.model.Permission;
import com.matbena.apquality.domain.repository.PermissionRepository;
import com.matbena.apquality.service.PermissionService;
import com.matbena.apquality.web.dto.PermissionDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PermissionServiceImp implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public PermissionDTO createPermission(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setName(permissionDTO.name());
        return entityToDto(permissionRepository.save(permission));
    }

    @Override
    public List<PermissionDTO> findAllPermissions() {
        return permissionRepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public PermissionDTO findPermission(String name) {
        return entityToDto(permissionRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found for name: " + name)));
    }

    @Override
    public PermissionDTO updatePermission(String name, PermissionDTO permissionDTO) {
        Permission permission = permissionRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found for name: " + name));

        permission.setName(permissionDTO.name());

        return entityToDto(permissionRepository.save(permission));
    }

    @Override
    public Boolean deletePermission(String name) {
        try {
            if (!permissionRepository.existsByName(name)){
                return false;
            } else {
                permissionRepository.deleteByName(name);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PermissionDTO entityToDto(Permission permission){
        return new PermissionDTO(permission.getName());
    }
}