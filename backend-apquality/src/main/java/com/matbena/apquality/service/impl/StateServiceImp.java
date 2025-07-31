package com.matbena.apquality.service.impl;

import com.matbena.apquality.domain.model.State;
import com.matbena.apquality.domain.repository.StateRepository;
import com.matbena.apquality.service.StateService;
import com.matbena.apquality.web.dto.StateDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StateServiceImp implements StateService {
    private final StateRepository stateRepository;

    @Override
    public StateDTO createState(StateDTO stateDTO) {
        State state = new State();
        state.setName(stateDTO.name());
        return entityToDto(stateRepository.save(state));
    }

    @Override
    public List<StateDTO> findAllStates() {
        return stateRepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public StateDTO findState(String name) {
        return entityToDto(stateRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("State not found for name: " + name)));
    }

    @Override
    public Boolean deleteState(String name) {
        try {
            if (!stateRepository.existsByName(name)) {
                return false;
            }
            stateRepository.deleteByName(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public StateDTO updateState(StateDTO stateDTO, String newName) {
        State state = stateRepository.findByName(stateDTO.name())
                .orElseThrow(() -> new EntityNotFoundException("State not found for name:" + stateDTO.name()));

        state.setName(newName);
        return entityToDto(stateRepository.save(state));
    }

    public StateDTO entityToDto(State state){
        return new StateDTO(state.getName());
    }
}
