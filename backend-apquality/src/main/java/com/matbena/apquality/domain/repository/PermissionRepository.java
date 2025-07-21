package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.Booking;
import com.matbena.apquality.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
