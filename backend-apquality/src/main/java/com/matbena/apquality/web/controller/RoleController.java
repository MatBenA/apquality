package com.matbena.apquality.web.controller;

import com.matbena.apquality.service.RoleService;
import com.matbena.apquality.web.dto.RoleDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public RoleDTO createRole(RoleDTO roleDTO){
        return roleService.createRole(roleDTO);
    }

    @GetMapping
    public List<RoleDTO> findAllRoles(RoleDTO roleDTO){
        return roleService.findAllRoles(roleDTO);
    }

    @GetMapping("/{name}")
    public RoleDTO findRole(@PathVariable String name){
        return roleService.findRole(name);
    }

    @PutMapping("/update/{name}")
    public RoleDTO updateRole(@PathVariable String name, @RequestBody RoleDTO roleDTO){
        return roleService.updateRole(name, roleDTO);
    }

    @DeleteMapping("/delete/{name}")
    public Boolean deleteRole(@PathVariable String name){
        return roleService.deleteRole(name);
    }
}