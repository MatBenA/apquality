package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Optional;

@Repository
public interface ScheduleRepository  extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByDayOfWeek(DayOfWeek dayOfWeek);

    boolean existsByDayOfWeek(DayOfWeek dayOfWeek);

    void deleteByDayOfWeek(DayOfWeek dayOfWeek);
}
