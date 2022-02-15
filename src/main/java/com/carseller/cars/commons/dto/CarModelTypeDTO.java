package com.carseller.cars.commons.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarModelTypeDTO extends BaseDTO{
    private String type;

    @Builder
    public CarModelTypeDTO(Integer id, LocalDateTime createdAt, String type) {
        super(id, createdAt);
        this.type = type;
    }
}
