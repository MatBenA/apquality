package com.matbena.apquality.domain.repository;

import com.matbena.apquality.domain.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository  extends JpaRepository<Schedule, Long> {
}
