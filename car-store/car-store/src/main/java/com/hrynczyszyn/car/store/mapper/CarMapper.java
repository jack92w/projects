package com.hrynczyszyn.car.store.mapper;

import com.hrynczyszyn.car.store.dto.CarDto;
import com.hrynczyszyn.car.store.entity.Car;

public interface CarMapper extends Mapper<CarDto, Car> {

    @Override
    CarDto mapToDto(Car car);

    @Override
    Car mapToEntity(CarDto carDto);
}
