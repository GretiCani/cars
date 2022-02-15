package com.carseller.cars.repositories;

import com.carseller.cars.domain.EngineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EngineTypeRepository extends JpaRepository<EngineType,Integer> {

    Optional<EngineType> findFirstByType(String type);

}
