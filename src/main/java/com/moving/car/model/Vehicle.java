package com.moving.car.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
public abstract class Vehicle {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private double price;

    public Vehicle(String brand, String model, double price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
}
