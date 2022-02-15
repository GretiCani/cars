package com.carseller.cars.service.impl;

import com.carseller.cars.commons.dto.CarModelDTO;
import com.carseller.cars.commons.exceptions.ResourceNotFound;
import com.carseller.cars.commons.xml.Catalogue;
import com.carseller.cars.domain.CarCatalogue;
import com.carseller.cars.repositories.CatalogueRepository;
import com.carseller.cars.service.CatalogueService;
import com.carseller.cars.service.ModelService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CatalogueServiceImpl implements CatalogueService {

    private final CatalogueRepository catalogueRepository;
    private final ModelService modelService;

    @Override
    public List<CarModelDTO> findCatalogueByBrand(String brand,String sorting) {
        CarCatalogue catalogue = catalogueRepository
                .findFirstByBrandIgnoreCase(brand)
                .orElseThrow(()->new ResourceNotFound("Catalogue for brand "+brand+" does not exist"));
        Sort sort = sorting.equals("ASC")?Sort.by(Sort.Direction.ASC,"name"):Sort.by(Sort.Direction.DESC,"name");
        return modelService
                .findAllByCatalogue(catalogue,sort);
    }

    @Override
    public void loadCatalogue(String fileLocation,String brand){
        try{
            Catalogue catalogue = new XmlMapper().readValue(ResourceUtils.getFile(fileLocation), Catalogue.class);
            log.info(catalogue.toString());
            CarCatalogue carCatalogue = catalogueRepository
                    .findFirstByBrandIgnoreCase(brand)
                    .orElseGet(()->catalogueRepository.save(new CarCatalogue(brand)));
            catalogue.getModelDTOS()
                    .stream()
                    .forEach(data ->modelService.addCarModel(data,null,carCatalogue));
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
        }

    }
}
