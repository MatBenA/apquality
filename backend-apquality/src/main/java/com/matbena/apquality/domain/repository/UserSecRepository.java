package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecRepository extends JpaRepository<UserSec, Long> {
    Optional<UserSec> findByEmail(String email);
}
