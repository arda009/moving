package com.moving.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Motorcycle extends JpaRepository<Motorcycle, Long> {
}
