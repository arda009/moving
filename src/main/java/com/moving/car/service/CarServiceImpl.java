package com.moving.car.service;

import com.moving.car.dto.CarDTO;
import com.moving.car.mapper.CarMapper;
import com.moving.car.model.Car;
import com.moving.car.repository.CarRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void add(CarDTO carDTO) {
        Car car = carMapper.convertToCar(carDTO);
        carRepository.save(car);
    }
    @Transactional
    public void addAll(List<CarDTO> carList) {
        List<Car> cars = carList.stream()
                        .map(carMapper::convertToCar)
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
