package com.carseller.cars.service.impl;

import com.carseller.cars.commons.dto.CarModelLineDTO;
import com.carseller.cars.commons.dto.CarModelTypeDTO;
import com.carseller.cars.commons.exceptions.ResourceNotFound;
import com.carseller.cars.commons.xml.Catalogue;
import com.carseller.cars.domain.*;
import com.carseller.cars.commons.dto.CarModelDTO;
import com.carseller.cars.repositories.*;
import com.carseller.cars.service.ModelService;
import com.carseller.cars.service.EngineService;
import com.carseller.cars.service.WheelsService;
import com.carseller.cars.commons.mappers.Mapper;
import com.carseller.cars.commons.xml.Model;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

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
           modelRepository.saveAll(this.addSubmodels(modelDTO.getSubmodels(),parent,catalogue));
    }

    public List<CarModel> addSubmodels(List<Model> childs,CarModel parent,CarCatalogue catalogue){
        return childs.stream()
                .map(child ->{
                    CarModel model = new CarModel();
                    model.setName(child.getName());
                    model.setFrom(child.getFrom());
                    model.setTo(child.getTo());
                    model.setLine(child.getLine()!=null?this.addModelLine(child.getLine()):null);
                    model.setParentModel(parent);
                    model.setCatalogue(catalogue);

                    if(child.getEngineDTO().getPower().equals(parent.getCarEngine().getPower()) &&
                            child.getEngineDTO().getType().equals(parent.getCarEngine().getType().getType())){
                        model.setCarEngine(parent.getCarEngine());
                    }else{
                        model.setCarEngine(engineService.addEngine(child.getEngineDTO()));
                    }
                    if(child.getWheelsDTO().getSize().equals(parent.getWheels().getSize()) &&
                            child.getWheelsDTO().getType().equals(parent.getWheels().getType().getType())){
                        model.setWheels(parent.getWheels());
                    }else{
                        model.setWheels(wheelsService.addWheels(child.getWheelsDTO()));
                    }
                    return model;
                }).collect(Collectors.toList());
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
