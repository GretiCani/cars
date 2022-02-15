package com.carseller.cars.service.impl;

import com.carseller.cars.commons.exceptions.ResourceNotFound;
import com.carseller.cars.domain.*;
import com.carseller.cars.commons.dto.CarModelDTO;
import com.carseller.cars.repositories.*;
import com.carseller.cars.service.ModelService;
import com.carseller.cars.service.EngineService;
import com.carseller.cars.service.WheelsService;
import com.carseller.cars.commons.mappers.Mapper;
import com.carseller.cars.commons.xml.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelTypeRepository modelTypeRepository;
    private final ModelLineRepository modelLineRepository;
    private final EngineService engineService;
    private final WheelsService wheelsService;

    @Override
    public CarModelDTO findCarModelById(Integer id) {
        return modelRepository
                .findById(id)
                .map(Mapper::toModelDTO)
                .orElseThrow(()->new ResourceNotFound("Model with id="+id+" does not exist"));
    }

    @Override
    public List<CarModelDTO> findAllByCatalogue(CarCatalogue catalogue, Sort sort) {
        return modelRepository
                .findAllByCatalogue(catalogue,sort)
                .stream()
                .map(Mapper::toModelDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addCarModel(Model modelDTO,CarModel parentModel,CarCatalogue catalogue) {
        CarModel parent = modelRepository
                .save(CarModel.builder()
                        .name(modelDTO.getName())
                        .from(modelDTO.getFrom())
                        .to(modelDTO.getTo())
                        .type(modelDTO.getType()!=null?this.addModelType(modelDTO.getType()):null)
                        .line(modelDTO.getLine()!=null?this.addModelLine(modelDTO.getLine()):null)
                        .carEngine(engineService.addEngine(modelDTO.getEngineDTO()))
                        .wheels(wheelsService.addWheels(modelDTO.getWheelsDTO()))
                        .catalogue(catalogue)
                        .parentModel(parentModel)
                        .build());
        if(modelDTO.getSubmodels()!=null)
            modelDTO.getSubmodels()
                    .stream()
                    .forEach(data->this.addCarModel(data,parent,catalogue));
    }

    @Override
    public ModelType addModelType(String type) {
        return modelTypeRepository.findFirstByType(type)
                .orElseGet(()->modelTypeRepository.save(new ModelType(type)));
    }

    @Override
    public ModelLine addModelLine(String line) {
        return modelLineRepository.findFirstByLine(line)
                .orElseGet(()->modelLineRepository.save(new ModelLine(line)));
    }

}
