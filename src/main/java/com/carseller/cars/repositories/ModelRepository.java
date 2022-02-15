package com.carseller.cars.repositories;

import com.carseller.cars.domain.CarCatalogue;
import com.carseller.cars.domain.CarModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<CarModel,Integer> {
    List<CarModel> findAllByCatalogue(CarCatalogue catalogue, Sort sort);
}
