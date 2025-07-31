package com.matbena.apquality.web.controller;

import com.matbena.apquality.service.ScheduleService;
import com.matbena.apquality.web.dto.ScheduleDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/create")
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO){
        return scheduleService.createSchedule(scheduleDTO);
    }

    @GetMapping
    public List<ScheduleDTO> findAllSchedules(){
        return scheduleService.findAllSchedules();
    }

    @GetMapping("/{dayOfWeek}")
    public ScheduleDTO findSchedule(@PathVariable DayOfWeek dayOfWeek){
        return scheduleService.findSchedule(dayOfWeek);
    }

    @PutMapping("/update/{dayOfWeek}")
    public ScheduleDTO updateSchedule(@PathVariable DayOfWeek dayOfWeek, @RequestBody ScheduleDTO scheduleDTO){
        return scheduleService.upddateSchedule(dayOfWeek, scheduleDTO);
    }

    @DeleteMapping("/delete/{dayOfWeek}")
    public Boolean deleteSchedule(@PathVariable DayOfWeek dayOfWeek){
        return scheduleService.deleteSchedule(dayOfWeek);
    }
}
