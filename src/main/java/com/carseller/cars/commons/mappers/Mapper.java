package com.carseller.cars.commons.mappers;

import com.carseller.cars.commons.dto.*;
import com.carseller.cars.domain.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Mapper {

    public static CarModelDTO toModelDTO(CarModel model){
        return CarModelDTO.builder().id(model.getId())
                .modelName(model.getName())
                .modelType(model.getParentModel()!=null?model.getParentModel().getType().getType():model.getType().getType())
                .modelLine(model.getLine()!=null?model.getLine().getLine():null)
                .from(model.getFrom())
                .to(model.getTo())
                .engineType(model.getCarEngine()!=null?model.getCarEngine().getType().getType(): null)
                .enginePower(model.getCarEngine()!=null?model.getCarEngine().getPower():null)
                .wheelsType(model.getWheels().getType().getType())
                .wheelsSize(model.getWheels().getSize())
                .parentId(model.getParentModel()!=null?model.getParentModel().getId():null)
                .catalogueId(model.getCatalogue().getId())
                .createdAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(model.getCreatedAt()), ZoneId.systemDefault()))
                .build();
    }

    public static CarEngineDTO toEngineDTO(CarEngine carEngine){
        return CarEngineDTO.builder()
                .id(carEngine.getId())
                .power(carEngine.getPower())
                .type(carEngine.getType().getType())
                .createdAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(carEngine.getCreatedAt()), ZoneId.systemDefault()))
                .build();
    }

    public static CarWheelsDTO toWheelsDTO(CarWheels wheels){
        return CarWheelsDTO.builder()
                .id(wheels.getId())
                .size(wheels.getSize())
                .type(wheels.getType().getType())
                .createdAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(wheels.getCreatedAt()), ZoneId.systemDefault()))
                .build();
    }

}
