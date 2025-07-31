package com.matbena.apquality.service;

import com.matbena.apquality.web.dto.StateDTO;

import java.util.List;

public interface StateService {
    StateDTO createState(StateDTO stateDTO);

    List<StateDTO> findAllStates();

    StateDTO findState(String name);

    Boolean deleteState(String name);

    StateDTO updateState(StateDTO stateDTO, String newName);
}
