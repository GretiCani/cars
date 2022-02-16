package com.carseller.cars.service;

import com.carseller.cars.domain.CarWheels;
import com.carseller.cars.domain.WheelsType;
import com.carseller.cars.commons.dto.CarWheelsDTO;
import com.carseller.cars.commons.xml.Wheels;

public interface WheelsService {
    CarWheels addWheels(Wheels wheelsDTO);
    WheelsType addWheelsType(String type);
}
