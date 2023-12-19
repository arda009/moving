package com.moving.car.service;

import com.moving.car.dto.CarDTO;
import com.moving.car.mapper.CarMapper;
import com.moving.car.model.Car;
import com.moving.car.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper){
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public void add(CarDTO carDTO) {
        System.out.println("DTO = " + carDTO);
        Car car = carMapper.convertToCar(carDTO);
        System.out.println(car);
        carRepository.save(car);
    }
    public void addAll(List<CarDTO> carList) {
        List<Car> cars = carList.stream()
                        .map((carDTO) -> carMapper.convertToCar(carDTO))
                        .collect(Collectors.toList());
        carRepository.saveAll(cars);
    }

    public CarDTO getCar(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        return carMapper.convertToDTO(car);
    }

    public List<Car> getAllCars(Pageable pageable) {
        return carRepository.findAll(pageable).getContent();
    }

}
