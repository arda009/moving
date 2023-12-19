package com.moving.car.service;

import com.moving.car.repository.MotorcycleRepository;
import org.springframework.stereotype.Service;

@Service
public class MotorcycleServiceImpl implements MotorcycleService{
    private MotorcycleRepository motorcycleRepository;

    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository){
        this.motorcycleRepository = motorcycleRepository;
    }
}
