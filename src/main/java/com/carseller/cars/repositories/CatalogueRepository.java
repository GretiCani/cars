package com.carseller.cars.repositories;

import com.carseller.cars.domain.CarCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogueRepository extends JpaRepository<CarCatalogue,Integer> {
    Optional<CarCatalogue> findFirstByBrandIgnoreCase(String brand);
}
