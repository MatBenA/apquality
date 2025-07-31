package com.matbena.apquality.web.controller;

import com.matbena.apquality.service.SalonServiceService;
import com.matbena.apquality.web.dto.SalonServiceDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/services")
public class SalonServiceController {

    private final SalonServiceService salonServiceService;

    @PutMapping("/create")
    public SalonServiceDTO createSalonService(@RequestBody SalonServiceDTO salonServiceDTO){
        return salonServiceService.createService(salonServiceDTO);
    }

    @GetMapping
    public List<SalonServiceDTO> getSalonServiceList(){
        return salonServiceService.findAllServices();
    }

    @GetMapping("/{name}")
    public SalonServiceDTO getSalonService(@PathVariable String name){
        return salonServiceService.findBySalonService(name);
    }

    @PutMapping("/update")
    public SalonServiceDTO updateSalonService(@RequestBody SalonServiceDTO salonServiceDTO){
        return salonServiceService.updateSalonService(salonServiceDTO);
    }

    @DeleteMapping("/delete/{name}")
    public Boolean deleteSalonByName(@PathVariable String name){
        return salonServiceService.deleteSalonService(name);
    }
}
