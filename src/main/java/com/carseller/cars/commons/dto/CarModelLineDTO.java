package com.carseller.cars.commons.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarModelLineDTO extends BaseDTO{
    private String line;

    @Builder
    public CarModelLineDTO(Integer id, LocalDateTime createdAt, String line) {
        super(id, createdAt);
        this.line = line;
    }
}
