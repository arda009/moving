package com.moving.car.controller;

import com.moving.car.dto.CarDTO;
import com.moving.car.errors.CarNotFoundException;
import com.moving.car.errors.CustomError;
import com.moving.car.model.Car;
import com.moving.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
public class CarController {
    private final CarService carService;

//    public CarController(CarService carService) {
//        this.carService = carService;
//    }

    @PostMapping("/add")
    public ResponseEntity<?> addCar(@RequestBody CarDTO car){
        carService.add(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }
    @PostMapping("/add/cars")
    public ResponseEntity<?> addAllCars(@RequestBody List<CarDTO> carList){
        carList.forEach(System.out::println);
        carService.addAll(carList);
        return ResponseEntity.ok(carList);
    }
    @GetMapping("/car/{id}")
    public ResponseEntity<?> getCar(@PathVariable Long id) {
        CarDTO car = carService.getCar(id);
        if (car == null) {
            throw new CarNotFoundException("Car not found");
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    @GetMapping("/cars")
    public ResponseEntity<?> getAllCars(@PageableDefault(size = 5) Pageable pageable){
        List<Car> cars = carService.getAllCars(pageable);
        if(cars.isEmpty()){
            throw new CarNotFoundException("Cars not found");
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
