package com.matbena.apquality.service;

import com.matbena.apquality.web.dto.SalonServiceDTO;

import java.util.List;

public interface SalonServiceService {
    SalonServiceDTO createService(SalonServiceDTO salonServiceDTO);
    List<SalonServiceDTO> findAllServices();
    SalonServiceDTO findBySalonService(String name);
    Boolean deleteSalonService(String name);
    SalonServiceDTO updateSalonService(SalonServiceDTO salonServiceDTO);
}