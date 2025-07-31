package com.matbena.apquality.service;

import com.matbena.apquality.web.dto.ScheduleDTO;

import java.time.DayOfWeek;
import java.util.List;

public interface ScheduleService {
    ScheduleDTO createSchedule(ScheduleDTO scheduleDTO);

    List<ScheduleDTO> findAllSchedules();

    ScheduleDTO findSchedule(DayOfWeek dayOfWeek);

    ScheduleDTO upddateSchedule(DayOfWeek dayOfWeek, ScheduleDTO scheduleDTO);

    Boolean deleteSchedule(DayOfWeek dayOfWeek);
}
