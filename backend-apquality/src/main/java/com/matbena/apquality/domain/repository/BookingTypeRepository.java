package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.BookingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BookingTypeRepository extends JpaRepository<BookingType, Long> {
    Optional<BookingType> findByName(String name);
    void deleteByName(String name);
    boolean existsByName(String name);
}