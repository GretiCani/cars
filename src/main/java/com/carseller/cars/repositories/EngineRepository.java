package com.carseller.cars.repositories;

import com.carseller.cars.domain.CarEngine;
import com.carseller.cars.domain.EngineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EngineRepository extends JpaRepository<CarEngine,Integer> {
    Optional<CarEngine> findFirstByPowerAndType(Integer power, EngineType engineType);

}
