package com.carseller.cars.service;

import com.carseller.cars.domain.CarEngine;
import com.carseller.cars.domain.EngineType;
import com.carseller.cars.commons.dto.CarEngineDTO;
import com.carseller.cars.commons.xml.Engine;

public interface EngineService {
    CarEngine addEngine(Engine engineDTO);
    EngineType addEngineType(String type);
}
