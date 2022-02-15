package com.carseller.cars.commons.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarModelDTO extends BaseDTO{
    private String modelName;
    private String modelType;
    private String modelLine;
    private Integer from;
    private Integer to;
    private String engineType;
    private Integer enginePower;
    private String wheelsType;
    private String wheelsSize;
    private Integer parentId;

    @Builder
    public CarModelDTO(Integer id, LocalDateTime createdAt, String modelName, String modelType, String modelLine, Integer from, Integer to, String engineType, Integer enginePower, String wheelsType, String wheelsSize, Integer parentId) {
        super(id, createdAt);
        this.modelName = modelName;
        this.modelType = modelType;
        this.modelLine = modelLine;
        this.from = from;
        this.to = to;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.wheelsType = wheelsType;
        this.wheelsSize = wheelsSize;
        this.parentId = parentId;
    }
}
