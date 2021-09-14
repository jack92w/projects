package com.hrynczyszyn.car.store.repository;

import com.hrynczyszyn.car.store.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findByHorsePowerGreaterThan(int horsePower);

    List<Car> findByHorsePowerLessThan(int horsePower);

    List<Car> findByBrand(String brand);

    List<Car> findByProductionYearGreaterThan(int year);

    List<Car> findByProductionYearLessThan(int year);

}
