package com.carseller.cars.commons.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarWheelsDTO extends BaseDTO{
    private String size;
    private String type;

    @Builder
    public CarWheelsDTO(Integer id, LocalDateTime createdAt, String size, String type) {
        super(id, createdAt);
        this.size = size;
        this.type = type;
    }
}
