package com.carseller.cars.commons.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarEngineDTO extends BaseDTO{
    private Integer power;
    private String type;

    @Builder
    public CarEngineDTO(Integer id, LocalDateTime createdAt, Integer power, String type) {
        super(id, createdAt);
        this.power = power;
        this.type = type;
    }
}
