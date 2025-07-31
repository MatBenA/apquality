package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByName(String name);

    void deleteByName(String name);

    boolean existsByName(String name);
}
