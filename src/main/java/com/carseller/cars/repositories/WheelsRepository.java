package com.carseller.cars.repositories;

import com.carseller.cars.domain.CarWheels;
import com.carseller.cars.domain.WheelsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WheelsRepository extends JpaRepository<CarWheels,Integer> {
    Optional<CarWheels> findFirstBySizeAndType(String size, WheelsType type);
}
