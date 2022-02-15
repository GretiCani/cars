package com.carseller.cars.commons.exceptions;

public class ResourceNotFound  extends RuntimeException{

    public ResourceNotFound(String message){
        super(message);
    }
}
