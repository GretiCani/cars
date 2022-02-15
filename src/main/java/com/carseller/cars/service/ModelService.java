package com.carseller.cars.service;

import com.carseller.cars.domain.*;
import com.carseller.cars.commons.dto.CarModelDTO;
import com.carseller.cars.commons.xml.Model;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ModelService {
     CarModelDTO findCarModelById(Integer id);
     List<CarModelDTO> findAllByCatalogue(CarCatalogue catalogue, Sort sort);
     void addCarModel(Model modelDTO,CarModel parent,CarCatalogue catalogue);
     ModelType addModelType(String type);
     ModelLine addModelLine(String line);


}
