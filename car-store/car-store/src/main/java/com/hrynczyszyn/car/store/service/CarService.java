package com.hrynczyszyn.car.store.service;

import com.hrynczyszyn.car.store.dto.CarDto;
import com.hrynczyszyn.car.store.entity.helper.CarHelper;

import java.util.List;

public interface CarService {

    /**
     * finds car by id
     *
     * @param id of car
     * @return carDto
     */
    CarDto findById(Long id);

    /**
     * finds cars by brand and model
     *
     * @param brand of car
     * @param model of car
     * @return list of cars
     */
    List<CarDto> findByBrandAndModel(String brand, String model);

    /**
     * finds cars by horsePower more than given value
     *
     * @param horsePower minimum
     * @return list of cars
     */
    List<CarDto> findByHorsePowerMoreThan(int horsePower);

    /**
     * finds cars by horsePower less than given value
     *
     * @param horsePower maximum
     * @return list of cars
     */
    List<CarDto> findByHorsePowerLessThan(int horsePower);

    /**
     * finds cars by brand
     *
     * @param brand of car
     * @return list of cars
     */
    List<CarDto> finByBrand(String brand);

    /**
     * finds car by year more than given value
     *
     * @param year of car
     * @return list of cars
     */
    List<CarDto> findByYearMoreThan(int year);

    /**
     * finds car by year less than given value
     *
     * @param year of car
     * @return list of cars
     */
    List<CarDto> findByYearLessThan(int year);

    /**
     * saves car
     *
     * @param carDto of car to be saved
     * @return saved carDto
     */
    CarDto saveCar(CarDto carDto);

    /**
     * saves cars
     *
     * @param carDtos of cars to be saved
     * @return list of saved cars
     */
    List<CarDto> saveCars(List<CarDto> carDtos);

    /**
     * updates car
     *
     * @param car to be updated
     * @return updated car
     */
    CarDto updateCar(CarHelper car);

    /**
     * removes car
     *
     * @param id of car to be removed
     */
    void deleteById(long id);


    /**
     * finds all cars
     * @return list of cars
     */
    List<CarDto> findAllCars();

}
