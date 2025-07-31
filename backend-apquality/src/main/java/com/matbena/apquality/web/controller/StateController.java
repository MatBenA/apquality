package com.matbena.apquality.web.controller;

import com.matbena.apquality.service.StateService;
import com.matbena.apquality.web.dto.StateDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/states")
public class StateController {
    private final StateService stateService;

    @PostMapping("/create")
    public StateDTO createState(@RequestBody StateDTO stateDTO){
        return stateService.createState(stateDTO);
    }

    @GetMapping
    public List<StateDTO> findAllStates(){
        return stateService.findAllStates();
    }

    @GetMapping("/{name}")
    public StateDTO findStateByName(@PathVariable String name){
        return stateService.findState(name);
    }

    @PutMapping("/update/{newName}")
    public StateDTO updateState(@RequestBody StateDTO stateDTO, @PathVariable String newName){
        return stateService.updateState(stateDTO, newName);
    }

    @DeleteMapping("/delete/{name}")
    public Boolean deleteState(@PathVariable String name){
        return stateService.deleteState(name);
    }
}
