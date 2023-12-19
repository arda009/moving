package com.moving.car.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Motorcycle extends Vehicle{
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String motorcycleType;

    public Motorcycle(String brand, String model, double price, String motorcycleType){
        super(brand, model, price);
        this.motorcycleType = motorcycleType;
    }
}
