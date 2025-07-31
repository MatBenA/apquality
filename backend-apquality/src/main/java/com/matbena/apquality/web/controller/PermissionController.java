package com.matbena.apquality.web.controller;

import com.matbena.apquality.service.PermissionService;
import com.matbena.apquality.web.dto.PermissionDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("/create")
    public PermissionDTO createPermission(@RequestBody PermissionDTO permissionDTO){
        return permissionService.createPermission(permissionDTO);
    }

    @GetMapping
    public List<PermissionDTO> getAllPermissions(){
        return permissionService.findAllPermissions();
    }

    @GetMapping("/{name}")
    public PermissionDTO getPermission(@PathVariable String name){
        return permissionService.findPermission(name);
    }

    @PutMapping("/update/{name}")
    public PermissionDTO updatePermission(@PathVariable String name, @RequestBody PermissionDTO permissionDTO){
        return permissionService.updatePermission(name, permissionDTO);
    }

    @DeleteMapping("/delete/{name}")
    public Boolean deletePermission(@PathVariable String name){
        return permissionService.deletePermission(name);
    }

}
