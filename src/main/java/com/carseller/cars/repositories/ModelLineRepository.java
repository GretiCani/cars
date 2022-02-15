package com.carseller.cars.repositories;

import com.carseller.cars.domain.ModelLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelLineRepository extends JpaRepository<ModelLine,Integer> {
    Optional<ModelLine> findFirstByLine(String line);
}
