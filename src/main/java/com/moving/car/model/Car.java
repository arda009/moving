package com.moving.car.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car extends Vehicle {

//    @Column
//    private String brand;
//    @Column
//    private String model;
    @Column
    private String color;
    @Column
    private int year;
    @Column
    private boolean sold;

    public Car(String brand, String model, String color, double price, int year, boolean sold){
        super(brand, model, price);
        this.color = color;
        this.sold = sold;
        this.year = year;

    }

}
