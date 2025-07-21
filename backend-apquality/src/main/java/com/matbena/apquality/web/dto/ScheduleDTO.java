package com.matbena.apquality.web.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record ScheduleDTO(DayOfWeek dayOfWeek,
                          LocalTime openingTime,
                          LocalTime closingTime) {
}
