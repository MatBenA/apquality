package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.Booking;
import com.matbena.apquality.domain.model.BookingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingTypeRepository extends JpaRepository<BookingType, Long> {
}
