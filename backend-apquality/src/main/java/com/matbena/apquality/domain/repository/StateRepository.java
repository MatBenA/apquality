package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository  extends JpaRepository<State, Long> {
}
