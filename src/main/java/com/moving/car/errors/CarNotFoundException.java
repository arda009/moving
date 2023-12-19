package com.moving.car.errors;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String message){
        super(message);
    }

}
