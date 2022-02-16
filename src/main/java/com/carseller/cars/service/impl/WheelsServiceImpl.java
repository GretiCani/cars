package com.carseller.cars.service.impl;

import com.carseller.cars.domain.CarWheels;
import com.carseller.cars.domain.WheelsType;
import com.carseller.cars.commons.exceptions.ResourceNotFound;
import com.carseller.cars.commons.dto.CarWheelsDTO;
import com.carseller.cars.commons.mappers.Mapper;
import com.carseller.cars.commons.xml.Wheels;
import com.carseller.cars.repositories.WheelsRepository;
import com.carseller.cars.repositories.WheelsTypeRepository;
import com.carseller.cars.service.WheelsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;

@RequiredArgsConstructor
@Service
public class WheelsServiceImpl implements WheelsService {

    private final WheelsRepository wheelsRepository;
    private final WheelsTypeRepository wheelsTypeRepository;

    @Override
    public CarWheels addWheels(Wheels wheelsDTO) {
        WheelsType type = this.addWheelsType(wheelsDTO.getType());
        return wheelsRepository.findFirstBySizeAndType(wheelsDTO.getSize(),type)
                .orElseGet(()->wheelsRepository.save(new CarWheels(wheelsDTO.getSize(),type)));
    }

    @Override
    public WheelsType addWheelsType(String type) {
        return wheelsTypeRepository.findFirstByType(type)
                .orElseGet(()->wheelsTypeRepository.save(new WheelsType(type)));
    }
}
