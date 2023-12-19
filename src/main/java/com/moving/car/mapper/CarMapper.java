package com.moving.car.mapper;

import com.moving.car.dto.CarDTO;
import com.moving.car.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final ModelMapper modelMapper;

    public CarMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    public CarDTO convertToDTO(Car car){
        return modelMapper.map(car, CarDTO.class);
    }
    public Car convertToCar(CarDTO carDTO){
        return modelMapper.map(carDTO, Car.class);
    }
}
