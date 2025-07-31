package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository  extends JpaRepository<State, Long> {
    Optional<State> findByName(String name);
    void deleteByName(String name);
    boolean existsByName(String name);
}