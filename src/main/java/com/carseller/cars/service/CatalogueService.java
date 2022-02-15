package com.carseller.cars.service;

import com.carseller.cars.commons.dto.CarModelDTO;

import java.util.List;

public interface CatalogueService {
    List<CarModelDTO> findCatalogueByBrand(String brand,String sort);
    void loadCatalogue(String fileLocation,String brand);
}
