package com.moving.car.dto;

import jakarta.persistence.Column;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Data
public class CarDTO {
    private String brand;
    private String model;
    private String color;
    private double price;
    private int year;
    private boolean sold;

}
