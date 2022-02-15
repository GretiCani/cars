package com.carseller.cars.repositories;

import com.carseller.cars.domain.ModelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelTypeRepository extends JpaRepository<ModelType,Integer> {
    Optional<ModelType> findFirstByType(String type);
}
