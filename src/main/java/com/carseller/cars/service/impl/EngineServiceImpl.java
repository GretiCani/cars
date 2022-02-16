package com.carseller.cars.service.impl;

import com.carseller.cars.domain.CarEngine;
import com.carseller.cars.domain.EngineType;
import com.carseller.cars.commons.exceptions.ResourceNotFound;
import com.carseller.cars.repositories.EngineRepository;
import com.carseller.cars.repositories.EngineTypeRepository;
import com.carseller.cars.service.EngineService;
import com.carseller.cars.commons.dto.CarEngineDTO;
import com.carseller.cars.commons.mappers.Mapper;
import com.carseller.cars.commons.xml.Engine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EngineServiceImpl implements EngineService {

    private final EngineRepository engineRepository;
    private final EngineTypeRepository engineTypeRepository;

    @Override
    public CarEngine addEngine(Engine engineDTO) {
        EngineType type = this.addEngineType(engineDTO.getType());
        return  engineRepository.findFirstByPowerAndType(engineDTO.getPower(),type)
                .orElseGet(()->engineRepository
                        .save(new CarEngine(engineDTO.getPower(),type)));
    }

    @Override
    public EngineType addEngineType(String type) {
        return engineTypeRepository.findFirstByType(type)
                .orElseGet(()->engineTypeRepository.save(new EngineType(type)));
    }


}
