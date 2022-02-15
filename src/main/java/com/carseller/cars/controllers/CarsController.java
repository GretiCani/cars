package com.carseller.cars.controllers;

import com.carseller.cars.commons.dto.*;
import com.carseller.cars.service.CatalogueService;
import com.carseller.cars.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CarsController {

    private final ModelService modelService;
    private final CatalogueService catalogueService;

    @GetMapping("/catalogue/{brand}/{sort}")
    public ResponseEntity<List<CarModelDTO>> findCatalogueByBrand(@PathVariable String brand,@PathVariable String sort){
        return ResponseEntity.ok(catalogueService.findCatalogueByBrand(brand,sort));
    }

    @GetMapping("/model/{id}/features")
    public ResponseEntity<CarModelDTO> getCarFeaturesById(@PathVariable Integer id){
        return ResponseEntity.ok(modelService.findCarModelById(id));
    }

}
