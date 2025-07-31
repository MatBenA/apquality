package com.matbena.apquality.service.impl;

import com.matbena.apquality.domain.model.Schedule;
import com.matbena.apquality.domain.repository.ScheduleRepository;
import com.matbena.apquality.service.ScheduleService;
import com.matbena.apquality.web.dto.ScheduleDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;

@AllArgsConstructor
@Service
public class ScheduleServiceImp implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setDayOfWeek(scheduleDTO.dayOfWeek());
        schedule.setOpeningTime(scheduleDTO.openingTime());
        schedule.setClosingTime(scheduleDTO.closingTime());

        return entityToDto(scheduleRepository.save(schedule));
    }

    @Override
    public List<ScheduleDTO> findAllSchedules() {
        return scheduleRepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public ScheduleDTO findSchedule(DayOfWeek dayOfWeek) {
        return entityToDto(scheduleRepository.findByDayOfWeek(dayOfWeek)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found for day: " + dayOfWeek)));
    }

    @Override
    public ScheduleDTO upddateSchedule(DayOfWeek dayOfWeek, ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleRepository.findByDayOfWeek(dayOfWeek)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found for day: " + dayOfWeek));

        schedule.setDayOfWeek(scheduleDTO.dayOfWeek());
        schedule.setOpeningTime(scheduleDTO.openingTime());
        schedule.setClosingTime(scheduleDTO.closingTime());

        return entityToDto(scheduleRepository.save(schedule));
    }

    @Override
    public Boolean deleteSchedule(DayOfWeek dayOfWeek) {
        try {
            if (!scheduleRepository.existsByDayOfWeek(dayOfWeek)){
                return false;
            } else {
                scheduleRepository.deleteByDayOfWeek(dayOfWeek);
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    public ScheduleDTO entityToDto(Schedule schedule){
        return new ScheduleDTO(
                schedule.getDayOfWeek(),
                schedule.getOpeningTime(),
                schedule.getClosingTime()
        );
    }
}