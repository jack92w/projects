package com.hrynczyszyn.car.store.mapper.impl;

import com.hrynczyszyn.car.store.dto.CarDto;
import com.hrynczyszyn.car.store.entity.Car;
import com.hrynczyszyn.car.store.mapper.CarMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapperImpl implements CarMapper {

    public CarDto mapToDto(Car car) {
        if (car != null) {
            return CarDto.builder()
                    .brand(car.getBrand())
                    .displacement(car.getDisplacement())
                    .fuelType(car.getFuelType())
                    .horsePower(car.getHorsePower())
                    .model(car.getModel())
                    .productionYear(car.getProductionYear())
                    .transmissionType(car.getTransmissionType())
                    .id(car.getId())
                    .build();
        }
        return null;
    }

    public Car mapToEntity(CarDto carDto) {
        if (carDto != null) {
            return Car.builder()
                    .brand(carDto.getBrand())
                    .displacement(carDto.getDisplacement())
                    .fuelType(carDto.getFuelType())
                    .horsePower(carDto.getHorsePower())
                    .model(carDto.getModel())
                    .productionYear(carDto.getProductionYear())
                    .transmissionType(carDto.getTransmissionType())
                    .id(carDto.getId())
                    .build();
        }
        return null;
    }
}
