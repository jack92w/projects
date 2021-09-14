package com.hrynczyszyn.car.store.service.impl;

import com.hrynczyszyn.car.store.dto.CarDto;
import com.hrynczyszyn.car.store.entity.Car;
import com.hrynczyszyn.car.store.entity.helper.CarHelper;
import com.hrynczyszyn.car.store.mapper.CarMapper;
import com.hrynczyszyn.car.store.repository.CarRepository;
import com.hrynczyszyn.car.store.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    CarRepository carRepository;
    CarMapper carMapper;

    CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDto findById(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        return carMapper.mapToDto(car);
    }

    @Override
    public List<CarDto> findByBrandAndModel(String brand, String model) {
        List<Car> cars = carRepository.findByBrandAndModel(brand, model);
        return carMapper.mapToDtos(cars);
    }

    @Override
    public List<CarDto> findByHorsePowerMoreThan(int horsePower) {
        List<Car> cars = carRepository.findByHorsePowerGreaterThan(horsePower);
        return carMapper.mapToDtos(cars);
    }

    @Override
    public List<CarDto> findByHorsePowerLessThan(int horsePower) {
        List<Car> cars = carRepository.findByHorsePowerLessThan(horsePower);
        return carMapper.mapToDtos(cars);
    }

    @Override
    public List<CarDto> finByBrand(String brand) {
        List<Car> cars = carRepository.findByBrand(brand);
        return carMapper.mapToDtos(cars);
    }

    @Override
    public List<CarDto> findByYearMoreThan(int year) {
        List<Car> cars = carRepository.findByProductionYearGreaterThan(year);
        return carMapper.mapToDtos(cars);
    }

    @Override
    public List<CarDto> findByYearLessThan(int year) {
        List<Car> cars = carRepository.findByProductionYearLessThan(year);
        return carMapper.mapToDtos(cars);
    }

    @Override
    public CarDto saveCar(CarDto carDto) {
        Car car = carMapper.mapToEntity(carDto);
        final Car savedCar = carRepository.save(car);
        return carMapper.mapToDto(savedCar);
    }

    @Override
    public List<CarDto> saveCars(List<CarDto> cars) {
        List<Car> car = carMapper.mapToEntities(cars);
        final List<Car> savedCars = carRepository.saveAll(car);
        return carMapper.mapToDtos(savedCars);
    }

    @Override
    public CarDto updateCar(CarHelper car) {
        Car existingCar = carRepository.findById(car.getId()).orElse(null);
        existingCar.setBrand(car.getBrand());
        existingCar.setDisplacement(car.getDisplacement());
        existingCar.setFuelType(car.getFuelType());
        existingCar.setHorsePower(car.getHorsePower());
        existingCar.setModel(car.getModel());
        existingCar.setProductionYear(car.getProductionYear());
        existingCar.setTransmissionType(car.getTransmissionType());
        final Car savedCar = carRepository.save(existingCar);
        return carMapper.mapToDto(savedCar);
    }

    @Override
    public void deleteById(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<CarDto> findAllCars() {
        List<Car> cars = carRepository.findAll();
        return carMapper.mapToDtos(cars);
    }

}
