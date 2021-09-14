package com.hrynczyszyn.car.store.controller;

import com.hrynczyszyn.car.store.dto.CarDto;
import com.hrynczyszyn.car.store.entity.helper.CarHelper;
import com.hrynczyszyn.car.store.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/car/{id}")
    public CarDto findById(@PathVariable long id) {
        return carService.findById(id);
    }

    @GetMapping("/cars")
    public List<CarDto> findAllCars() {
        return carService.findAllCars();
    }

    @GetMapping("/carsByBrandAndModel")
    public List<CarDto> findByBrandAndModel(@RequestBody CarHelper car) {
        return carService.findByBrandAndModel(car.getBrand(), car.getModel());
    }

    @GetMapping("/carsByBrand/{brand}")
    public List<CarDto> findByBrand(@PathVariable String brand) {
        return carService.finByBrand(brand);
    }

    @GetMapping("/carsWithHorsePowerMoreThan/{horsePower}")
    public List<CarDto> findByHorsePowerMoreThan(@PathVariable int horsePower) {
        return carService.findByHorsePowerMoreThan(horsePower);
    }

    @GetMapping("/carsWithHorsePowerLessThan/{horsePower}")
    public List<CarDto> findByHorsePowerLessThan(@PathVariable int horsePower) {
        return carService.findByHorsePowerLessThan(horsePower);
    }

    @GetMapping("/carsWithYearMoreThan/{year}")
    public List<CarDto> findByYearMoreThan(@PathVariable int year) {
        return carService.findByYearMoreThan(year);
    }

    @GetMapping("/carsWithYearLessThan/{year}")
    public List<CarDto> findByYearLessThan(@PathVariable int year) {
        return carService.findByYearLessThan(year);
    }

    @PostMapping("/addCar")
    public CarDto addCar(@Valid @RequestBody CarDto car) {
        return carService.saveCar(car);
    }

    @PostMapping("/addCars")
    public List<CarDto> addCars(@RequestBody List<CarDto> cars) {
        return carService.saveCars(cars);
    }

    @PutMapping("/update")
    public CarDto update(@RequestBody CarHelper car) {
        return carService.updateCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        carService.deleteById(id);
    }

}
