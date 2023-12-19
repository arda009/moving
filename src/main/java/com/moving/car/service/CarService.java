package com.moving.car.service;

import com.moving.car.dto.CarDTO;
import com.moving.car.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {

    void add(CarDTO car);
    void addAll(List<CarDTO> carList);
    CarDTO getCar(Long id);
    List<Car> getAllCars(Pageable pageable);

}
