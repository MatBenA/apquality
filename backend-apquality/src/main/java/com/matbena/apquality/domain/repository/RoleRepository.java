package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
