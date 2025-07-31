package com.matbena.apquality.service.impl;

import com.matbena.apquality.domain.model.SalonService;
import com.matbena.apquality.domain.repository.SalonServiceRepository;
import com.matbena.apquality.service.SalonServiceService;
import com.matbena.apquality.web.dto.SalonServiceDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SalonServiceServiceImp implements SalonServiceService {
    private final SalonServiceRepository salonServiceRepository;

    @Override
    public SalonServiceDTO createService(SalonServiceDTO salonServiceDTO) {
        SalonService salonService = new SalonService();
        salonService.setName(salonServiceDTO.name());
        salonService.setPrice(salonServiceDTO.price());

        return entityToDto(salonServiceRepository.save(salonService));
    }

    @Override
    public List<SalonServiceDTO> findAllServices() {
        return salonServiceRepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public SalonServiceDTO findBySalonService(String name) {
        return entityToDto(salonServiceRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("SalonService not found for name: " + name)));
    }

    @Override
    public Boolean deleteSalonService(String name) {
        return salonServiceRepository.deleteByName(name);
    }

    @Override
    public SalonServiceDTO updateSalonService(SalonServiceDTO salonServiceDTO) {
        SalonService salonService = new SalonService();
        salonService.setName(salonServiceDTO.name());
        salonService.setPrice(salonServiceDTO.price());
        return entityToDto(salonServiceRepository.save(salonService));
    }

    public SalonServiceDTO entityToDto(SalonService salonService) {
        return new SalonServiceDTO(salonService.getName(), salonService.getPrice());
    }
}
