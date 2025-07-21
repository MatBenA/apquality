package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository  extends JpaRepository<Service, Long> {
}
