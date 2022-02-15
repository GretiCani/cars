package com.carseller.cars.repositories;

import com.carseller.cars.domain.WheelsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WheelsTypeRepository extends JpaRepository<WheelsType,Integer> {
    Optional<WheelsType> findFirstByType(String type);
}
